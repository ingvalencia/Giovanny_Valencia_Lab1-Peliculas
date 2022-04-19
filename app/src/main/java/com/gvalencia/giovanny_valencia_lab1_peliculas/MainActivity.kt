package com.gvalencia.giovanny_valencia_lab1_peliculas

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.gvalencia.giovanny_valencia_lab1_peliculas.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var myVideoView: VideoView? = null
    private  var myMediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.inicioFragment, R.id.registroFragment, R.id.trailersFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        //


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    /***************************************************/
    fun click(view: View){

        /*Toast.makeText(this@MainActivity, "Dato 1 es el radio, Dato 2 es la altura.",
            Toast.LENGTH_SHORT).show()
        */


        //val name = R.id.Nombres.



        //binding.nombres


        validaCampos()








    }


    /***************************************************/
    private  fun validaCampos(){

        val nombre = findViewById<EditText>(R.id.Nombres)
        val correo = findViewById<EditText>(R.id.Correo)
        val password = findViewById<EditText>(R.id.Password)

        val passwordRegex = Pattern.compile(
            "^[a-z0-9]{6,}$"

        )

        if(nombre.text.toString().isEmpty()){

            nombre.error = "Se requiere un nombre."
            nombre.requestFocus()

        }else if(correo.text.toString().isEmpty()){

            correo.error = "Se requiere un correo eléctronico."
            correo.requestFocus()

        }else if(!PatternsCompat.EMAIL_ADDRESS.matcher(correo.text.toString()).matches()){

            correo.error = "Se requiere un correo eléctronico válido."
            correo.requestFocus()

        }else if(password.text.toString().isEmpty()){

            password.error = "Se requiere un password."
            password.requestFocus()

        }else if(!passwordRegex.matcher(password.text.toString()).matches()){

            password.error = "Se requiere un password con al menos 6 carácteres, una letra y un número."
            password.requestFocus()

        }else{

            Toast.makeText(this@MainActivity, "Registro exitoso.",
                Toast.LENGTH_SHORT).show()

            nombre.setText("")
            correo.setText("")
            password.setText("")
        }

    }
    /***************************************************/



    /***************************************************/
    fun clickBatman(view: View) {
        Navigation.findNavController(view).navigate(R.id.batman)

        //myVideoView = findViewById<VideoView>(R.id.videoBatman)
        //setUpVideoPLayer()


     //AQUI LOS VIDEOS
        /*
        val vidBatman = findViewById<VideoView>(R.id.videoBatman)
        vidBatman.setVideoPath("android.resource://"+getPackageName()+"/"+ R.raw.batman)

        val mcBatman:MediaController = MediaController(this)
        mcBatman.setAnchorView(vidBatman)
        vidBatman.setMediaController(mcBatman)
    */

    }

    private fun setUpVideoPLayer(){

        /*Toast.makeText(this@MainActivity, "Video.",
            Toast.LENGTH_SHORT).show()*/

        if (myMediaController == null){
            myMediaController = MediaController(this)
            myMediaController!!.setAnchorView(this.myVideoView)
        }

        myVideoView!!.setMediaController(myMediaController)

        myVideoView!!.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.batman))

        myVideoView!!.requestFocus()

        myVideoView!!.pause()
        
        myVideoView!!.setOnCompletionListener {Toast.makeText(applicationContext, "Video Completed",
            Toast.LENGTH_SHORT).show()
        }
        
        myVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occured",Toast.LENGTH_SHORT).show()
            false
        }

    }

    /***************************************************/
    fun clickDoctor(view: View) {
        Navigation.findNavController(view).navigate(R.id.doctor)

    }

    /***************************************************/
    fun clickAnimales(view: View) {
        Navigation.findNavController(view).navigate(R.id.animales)

    }

    /***************************************************/
    fun clickSpiderman(view: View) {
        Navigation.findNavController(view).navigate(R.id.spiderman)

    }

    /***************************************************/
    fun clickSing(view: View) {
        Navigation.findNavController(view).navigate(R.id.sing)

    }



}