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
@Table(name = "yayinevi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yayinevi.findAll", query = "SELECT y FROM Yayinevi y"),
    @NamedQuery(name = "Yayinevi.findByYayineviId", query = "SELECT y FROM Yayinevi y WHERE y.yayineviId = :yayineviId"),
    @NamedQuery(name = "Yayinevi.findByYayineviAdi", query = "SELECT y FROM Yayinevi y WHERE y.yayineviAdi = :yayineviAdi"),
    @NamedQuery(name = "Yayinevi.findByYayineviAciklama", query = "SELECT y FROM Yayinevi y WHERE y.yayineviAciklama = :yayineviAciklama")})
public class Yayinevi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "yayinevi_id")
    private Integer yayineviId;
    @Size(max = 20)
    @Column(name = "yayinevi_adi")
    private String yayineviAdi;
    @Size(max = 45)
    @Column(name = "yayinevi_aciklama")
    private String yayineviAciklama;
    @OneToMany(mappedBy = "yayId")
    private Collection<Kitap> kitapCollection;

    public Yayinevi() {
    }

    public Yayinevi(Integer yayineviId) {
        this.yayineviId = yayineviId;
    }

    public Integer getYayineviId() {
        return yayineviId;
    }

    public void setYayineviId(Integer yayineviId) {
        this.yayineviId = yayineviId;
    }

    public String getYayineviAdi() {
        return yayineviAdi;
    }

    public void setYayineviAdi(String yayineviAdi) {
        this.yayineviAdi = yayineviAdi;
    }

    public String getYayineviAciklama() {
        return yayineviAciklama;
    }

    public void setYayineviAciklama(String yayineviAciklama) {
        this.yayineviAciklama = yayineviAciklama;
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
        hash += (yayineviId != null ? yayineviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yayinevi)) {
            return false;
        }
        Yayinevi other = (Yayinevi) object;
        if ((this.yayineviId == null && other.yayineviId != null) || (this.yayineviId != null && !this.yayineviId.equals(other.yayineviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Yayinevi[ yayineviId=" + yayineviId + " ]";
    }
    
}
