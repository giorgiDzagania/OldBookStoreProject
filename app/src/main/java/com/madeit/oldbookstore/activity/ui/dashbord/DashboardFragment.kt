package com.madeit.oldbookstore.activity.ui.dashbord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.ui.ads.AdsFragment
import com.madeit.oldbookstore.activity.ui.home.HomeFragment
import com.madeit.oldbookstore.activity.ui.inbox.InboxFragment
import com.madeit.oldbookstore.activity.ui.profile.ProfileFragment
import com.madeit.oldbookstore.activity.ui.sell.SellFragment
import com.madeit.oldbookstore.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var binding: FragmentDashboardBinding? = null
    private val homeFragment = HomeFragment()
    private val inboxFragment = InboxFragment()
    private val profileFragment = ProfileFragment()
    private val sellFragment = SellFragment()
    private val adsFragment = AdsFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        binding?.bottomNavigationView?.setOnNavigationItemSelectedListener(this)
        binding?.bottomNavigationView?.selectedItemId = R.id.home
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.flFragment, homeFragment)?.commit()
                return true
            }
            R.id.inbox -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.flFragment, inboxFragment)?.commit()
                return true
            }
            R.id.sell -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.flFragment, sellFragment)?.commit()
                return true
            }
            R.id.ads -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.flFragment, adsFragment)?.commit()
                return true
            }
            R.id.profile -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.flFragment, profileFragment)?.commit()
                return true
            }
        }
        return false
    }
}