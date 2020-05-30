package com.example.asrekaf.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.asrekaf.R
import com.example.asrekaf.home.import.ImportFragment
import kotlinx.android.synthetic.main.activity_home.*
import timber.log.Timber


class HomeActivity :
    AppCompatActivity(),
    HomeFragment.OnFragmentInteractionListener,
    ImportFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("onCreate started")
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment())
                .commit()
        }
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun changeToolbar(fragmentName: String) {
        toolbar.title = fragmentName
    }

    override fun showToken(token: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun backToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
