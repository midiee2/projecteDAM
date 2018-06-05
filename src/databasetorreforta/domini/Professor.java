/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.domini;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PROFESSOR")
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findByUsuari", query = "SELECT p FROM Professor p WHERE p.usuari = :usuari")
    , @NamedQuery(name = "Professor.findByNom", query = "SELECT p FROM Professor p WHERE p.nom = :nom")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USUARI")
    private String usuari;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "CONTRASSENYA")
    private String contrasenya;
    @ManyToMany(mappedBy = "professorList")
    private List<Classe> classeList;
    @OneToMany(mappedBy = "professor")
    private List<Assignatura> assignaturaList;
    
    
    
    public Professor() {
    }

    public Professor(String usuari) {
        this.usuari = usuari;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    
    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    public List<Assignatura> getAssignaturaList() {
        return assignaturaList;
    }

    public void setAssignaturaList(List<Assignatura> assignaturaList) {
        this.assignaturaList = assignaturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuari != null ? usuari.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.usuari == null && other.usuari != null) || (this.usuari != null && !this.usuari.equals(other.usuari))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databasetorreforta.domini.Professor[ usuari=" + usuari + " ]";
    }
    
}
