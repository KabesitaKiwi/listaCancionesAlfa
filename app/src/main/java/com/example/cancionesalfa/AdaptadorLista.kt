package com.example.cancionesalfa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.cancionesalfa.aplicacion.RepositorioSingleton
import com.example.cancionesalfa.casos_uso.AppController
import com.example.cancionesalfa.datos.RepositorioCanciones

class AdaptadorLista(
    val contexto: Context,
    val inflador: LayoutInflater = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
    : RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {


    lateinit var controlador: AppController

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int
    ): CreadorItems {
        controlador = AppController(contexto)
        val vista = inflador.inflate(R.layout.elemento_lista, parent, false)
        return CreadorItems(vista, controlador)
    }

    override fun onBindViewHolder(holder: CreadorItems, position: Int) {

        val cancion = RepositorioSingleton.getInstancia().repo.elemento(position)
        holder.titulo.text = cancion.titulo
        holder.album.text = cancion.album
        holder.descripcion.text = cancion.descripcion
        val draw = AppCompatResources.getDrawable(contexto,cancion.getImagen())
        holder.portada.setImageResource(cancion.getImagen())


    }

    override fun getItemCount(): Int {
        return RepositorioSingleton.getInstancia().repo.tamanno()
    }


    class CreadorItems(
        val view: View, val controlador: AppController,
        val titulo: TextView = view.findViewById(R.id.recTitulo),
        val album: TextView = view.findViewById(R.id.recAlbum),
        val descripcion: TextView = view.findViewById(R.id.recDescripcion),
        val portada: ImageView = view.findViewById(R.id.recFoto)
    ) : RecyclerView.ViewHolder(view){
        init {
            val layout = itemView.findViewById<LinearLayout>(R.id.layout_elemento)
            layout.setOnClickListener {
                val posicion = bindingAdapterPosition
                controlador.VistaCancion(posicion)


            }

        }
    }


}