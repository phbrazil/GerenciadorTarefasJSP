/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarTarefas.model;

/**
 *
 * @author paulo.bezerra
 */
public class tarefa {
    
    private int id;
    private String nome;
    private String descricao;
    private String status;
    private String responsavel;
    private String datainicio;
    private String datafim;
    private int nota;
    
    private tarefa(){
        
    }

    public tarefa(int id, String nome, String descricao, String status, String responsavel, String datainicio, String datafim, int nota) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.nota = nota;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getDatafim() {
        return datafim;
    }

    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
    
}
