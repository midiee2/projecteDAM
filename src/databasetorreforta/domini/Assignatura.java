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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sergi
 */
@Entity
@Table(name = "ASSIGNATURA")
@NamedQueries({
    @NamedQuery(name = "Assignatura.findAll", query = "SELECT a FROM Assignatura a")
    , @NamedQuery(name = "Assignatura.findById", query = "SELECT a FROM Assignatura a WHERE a.id = :id")
    , @NamedQuery(name = "Assignatura.findByNom", query = "SELECT a FROM Assignatura a WHERE a.nom = :nom")})
public class Assignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NOM")
    private String nom;
    @JoinTable(name = "CLASSEASSIGNATURA", joinColumns = {
        @JoinColumn(name = "ASSIGNATURA", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CLASSE", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Classe> classeList;
    @JoinColumn(name = "PROFESSOR", referencedColumnName = "USUARI")
    @ManyToOne
    private Professor professor;

    public Assignatura() {
    }

    public Assignatura(String id) {
        this.id = id;
        classeList = new ArrayList<>();
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

    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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
        if (!(object instanceof Assignatura)) {
            return false;
        }
        Assignatura other = (Assignatura) object;
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
