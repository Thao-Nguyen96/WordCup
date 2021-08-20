package com.nxt.ltday17.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nxt.ltday17.R
import com.nxt.ltday17.adapter.MatchAdapter
import com.nxt.ltday17.api.WorldCupUtil
import com.nxt.ltday17.model.Match
import kotlinx.android.synthetic.main.layout_viewpager_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchFragment : Fragment() {
    var listMatch: ArrayList<Match>? = null
    var adapter: MatchAdapter? = null

  /** companion object {
        private var matchFragment: MatchFragment? = null

        fun getInstance(): MatchFragment {
            if (matchFragment == null) {
                matchFragment = MatchFragment()
            }
            return matchFragment as MatchFragment
        }
    }
  */

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      Log.d("aaa", "1")

        val view = inflater.inflate(R.layout.layout_viewpager_item, container, false)

        val rvMatch: RecyclerView = view.findViewById(R.id.rv_matches)

        rvMatch.layoutManager = LinearLayoutManager(context)
        rvMatch.adapter = adapter
        WorldCupUtil.getWorCupService().getAllMatches()
            .enqueue(object : Callback<List<Match>> {
                override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                    listMatch?.clear()
                    listMatch?.addAll(response.body()!!)
                    adapter?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<List<Match>>, t: Throwable) {

                }
            })

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("aaa", "oncreate")
        super.onCreate(savedInstanceState)
        listMatch = ArrayList()
        adapter = MatchAdapter(listMatch!!)
    }
}

