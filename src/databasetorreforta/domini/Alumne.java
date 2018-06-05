/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.domini;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sergi
 */
@Entity
@Table(name = "ALUMNE")
@NamedQueries({
    @NamedQuery(name = "Alumne.findAll", query = "SELECT a FROM Alumne a")
    , @NamedQuery(name = "Alumne.findByDni", query = "SELECT a FROM Alumne a WHERE a.dni = :dni")
    , @NamedQuery(name = "Alumne.findByNom", query = "SELECT a FROM Alumne a WHERE a.nom = :nom")})
public class Alumne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "CLASSE", referencedColumnName = "ID")
    @ManyToOne
    private Classe classe;

    public Alumne() {
    }

    public Alumne(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumne)) {
            return false;
        }
        Alumne other = (Alumne) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databasetorreforta.domini.Alumne[ dni=" + dni + " ]";
    }
    
}
