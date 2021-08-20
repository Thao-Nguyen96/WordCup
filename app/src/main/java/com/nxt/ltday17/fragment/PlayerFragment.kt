package com.nxt.ltday17.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nxt.ltday17.R
import com.nxt.ltday17.adapter.PlayerAdapter
import com.nxt.ltday17.api.WorldCupUtil
import com.nxt.ltday17.model.Player
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PlayerFragment : Fragment() {
    private var adapter: PlayerAdapter? = null
    private var listPlayer: ArrayList<Player>? = null

    /**companion object {
    private var playerFragment: PlayerFragment? = null

    fun getInstance(): PlayerFragment {
    if (playerFragment == null) {
    playerFragment = PlayerFragment()
    }
    return playerFragment as PlayerFragment
    }
    }
     */

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_viewpager_item, container, false)

        val rvPlay: RecyclerView = view.findViewById(R.id.rv_matches)
        rvPlay.layoutManager = LinearLayoutManager(context)
        rvPlay.adapter = adapter

        WorldCupUtil.getWorCupService().getAllPlayer()
            .enqueue(object : retrofit2.Callback<List<Player>> {
                override fun onResponse(
                    call: Call<List<Player>>,
                    response: Response<List<Player>>
                ) {
                    listPlayer?.clear()
                    listPlayer?.addAll(response.body()!!)
                    adapter?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<List<Player>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listPlayer = ArrayList()
        adapter = PlayerAdapter(listPlayer!!)
        /** listPlayer!!.add(
        Player(
        1,
        "Trung doan",
        "Vietnam",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png",
        "facebook.com"
        )
        )
        listPlayer!!.add(
        Player(
        1,
        "Trung doan",
        "Vietnam",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png",
        "facebook.com"
        )
        )
        listPlayer!!.add(
        Player(
        1,
        "Trung doan",
        "Vietnam",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png",
        "facebook.com"
        )
        )
        listPlayer!!.add(
        Player(
        1,
        "Trung doan",
        "Vietnam",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png",
        "facebook.com"
        )
        )

        adapter = PlayerAdapter(listPlayer!!)
         */
    }
}