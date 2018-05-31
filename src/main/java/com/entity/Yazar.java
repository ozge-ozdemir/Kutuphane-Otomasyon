/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ozgeee
 */
@Entity
@Table(name = "yazar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yazar.findAll", query = "SELECT y FROM Yazar y"),
    @NamedQuery(name = "Yazar.findByYazarId", query = "SELECT y FROM Yazar y WHERE y.yazarId = :yazarId"),
    @NamedQuery(name = "Yazar.findByYazarAdi", query = "SELECT y FROM Yazar y WHERE y.yazarAdi = :yazarAdi"),
    @NamedQuery(name = "Yazar.findByYazarAciklama", query = "SELECT y FROM Yazar y WHERE y.yazarAciklama = :yazarAciklama")})
public class Yazar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "yazar_id")
    private Integer yazarId;
    @Size(max = 20)
    @Column(name = "yazar_adi")
    private String yazarAdi;
    @Size(max = 50)
    @Column(name = "yazar_aciklama")
    private String yazarAciklama;
    @OneToMany(mappedBy = "yazId")
    private Collection<Kitap> kitapCollection;

    public Yazar() {
    }

    public Yazar(Integer yazarId) {
        this.yazarId = yazarId;
    }

    public Integer getYazarId() {
        return yazarId;
    }

    public void setYazarId(Integer yazarId) {
        this.yazarId = yazarId;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getYazarAciklama() {
        return yazarAciklama;
    }

    public void setYazarAciklama(String yazarAciklama) {
        this.yazarAciklama = yazarAciklama;
    }

    @XmlTransient
    public Collection<Kitap> getKitapCollection() {
        return kitapCollection;
    }

    public void setKitapCollection(Collection<Kitap> kitapCollection) {
        this.kitapCollection = kitapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yazarId != null ? yazarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yazar)) {
            return false;
        }
        Yazar other = (Yazar) object;
        if ((this.yazarId == null && other.yazarId != null) || (this.yazarId != null && !this.yazarId.equals(other.yazarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Yazar[ yazarId=" + yazarId + " ]";
    }
    
}
