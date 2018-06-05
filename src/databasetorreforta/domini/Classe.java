/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.domini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sergi
 */
@Entity
@Table(name = "CLASSE")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findById", query = "SELECT c FROM Classe c WHERE c.id = :id")
    , @NamedQuery(name = "Classe.findByNom", query = "SELECT c FROM Classe c WHERE c.nom = :nom")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NOM")
    private String nom;
    @ManyToMany(mappedBy = "classeList")
    private List<Assignatura> assignaturaList;
    @JoinTable(name = "CLASSEPROFESSOR", joinColumns = {
        @JoinColumn(name = "CLASSE", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PROFESSOR", referencedColumnName = "USUARI")})
    @ManyToMany
    private List<Professor> professorList;
    @OneToMany(mappedBy = "classe")
    private List<Alumne> alumneList;

    public Classe() {
    }

    public Classe(String id) {
        this.id = id;
        assignaturaList = new ArrayList<>();
        professorList = new ArrayList<>();
        alumneList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Assignatura> getAssignaturaList() {
        return assignaturaList;
    }

    public void setAssignaturaList(List<Assignatura> assignaturaList) {
        this.assignaturaList = assignaturaList;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<Alumne> getAlumneList() {
        return alumneList;
    }

    public void setAlumneList(List<Alumne> alumneList) {
        this.alumneList = alumneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }

}
