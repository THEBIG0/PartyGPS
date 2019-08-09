package gunt0023.example.partygps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.database.*


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //go to Tools > Firebase > Realtime Database for documentation
    private var databaseCloud: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var myRef: DatabaseReference = databaseCloud.getReference("/lists")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {

                view ->
            Snackbar.make(view, "Sent message to cloud database", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //adds the value to the database
            myRef.setValue("Hello,World!")
        }

        setupUI()
    }

    private fun setupUI(){

        sign_out_button_main.setOnClickListener {

            startActivity(SignInActivity.getLaunchIntent(this))
        }
    }


    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
