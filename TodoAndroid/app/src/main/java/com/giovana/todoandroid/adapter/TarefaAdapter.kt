package com.giovana.todoandroid.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giovana.todoandroid.MainViewModel
import com.giovana.todoandroid.databinding.CardLayoutBinding
import com.giovana.todoandroid.model.Tarefa
import java.text.SimpleDateFormat
//------35 - Atualizando Tarefas------p8
//{
//criando um construtor na class TarefaAdapter
class TarefaAdapter (
    val taskClickListener: TaskClickListener,
    //para atualizar de forma dinamica
    val mainViewModel: MainViewModel,
    //------37 - Deletando Tarefas (criando o alerta)------p5
    //{
    val context: Context
    //}
        ): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {
//}

    private var listTarefa = emptyList<Tarefa>()

    class TarefaViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(
            CardLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefa[position]

        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        //Formatando a data{
        val formatter = SimpleDateFormat("yyy-mm-dd")
        val date = formatter.parse(tarefa.data)
        holder.binding.textData.text = formatter.format(date!!)
        //}
        holder.binding.switchAtivo.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.categoria.descricao

        //------35 - Atualizando Tarefas------p9
        //{

        holder.itemView.setOnClickListener {
            taskClickListener.onTaskClickListener(tarefa)
        }

        //------36 - Atualizando Tarefas II ------p4
        //{
        //para trocar o status pela FormFragment msm e guardar a mudança no bd
        holder.binding.switchAtivo
            .setOnCheckedChangeListener { compoundButton, ativo ->
                tarefa.status = ativo
                mainViewModel.updateTarefa(tarefa)
            }
        //}
        //}

        //------37 - Deletando Tarefas------p4
        //{
        //ultimo passo para deletar
        holder.binding.buttonDeletar.setOnClickListener {
            //mainViewModel.deleteTarefa(tarefa.id)
            //------37 - Deletando Tarefas (criando o alerta)------p7
            //{
            showAlertDialog(tarefa.id)
            //}
        }
        //}
    }

    override fun getItemCount(): Int {
        return listTarefa.size
    }

    fun setList(list: List<Tarefa>) {
        //------36 - Atualizando Tarefas II ------p2
        //{
        //ordenando pelo id
        //crescente -> "listTarefa = list.sortedBy { it.id }"
        //decrescente
        listTarefa = list.sortedByDescending { it.id }
        //}
        notifyDataSetChanged()
    }
    //------37 - Deletando Tarefas (criando o alerta)------p6
    //{
    private fun showAlertDialog(id: Long){
        AlertDialog.Builder(context)
            .setTitle("Excluir Tarefa")
            .setMessage("Deseja Excluir a Tarefa?")
            .setPositiveButton("Sim"){
                _,_ -> mainViewModel.deleteTarefa(id)
            }
            .setNegativeButton("Não"){
                _,_ ->
            }.show()
    }
    //}

}