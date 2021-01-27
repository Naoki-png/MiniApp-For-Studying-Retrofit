package com.example.webapplication.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webapplication.R
import com.example.webapplication.adapter.HomeAdapter
import com.example.webapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.internal.InjectedFieldSignature
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {

    @Inject lateinit var mAdapter : HomeAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)
        setRecyclerView(view)

        mainViewModel.readArticle.observe(viewLifecycleOwner, { newsEntity ->
            if (newsEntity != null) {
                mAdapter.setList(newsEntity.article.newsList)
            }
        })

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        val searchMenu = menu.findItem(R.id.search_menu).actionView as SearchView
        searchMenu.setOnQueryTextListener(this)
        searchMenu.isSubmitButtonEnabled = true
        searchMenu.queryHint = "Search news"
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            mainViewModel.getNews(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun setRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.home_recyclerView)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)
    }

}