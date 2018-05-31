/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozgeee
 */
@Entity
@Table(name = "kitap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitap.findAll", query = "SELECT k FROM Kitap k"),
    @NamedQuery(name = "Kitap.findByKitapId", query = "SELECT k FROM Kitap k WHERE k.kitapId = :kitapId"),
    @NamedQuery(name = "Kitap.findByKitapAdi", query = "SELECT k FROM Kitap k WHERE k.kitapAdi = :kitapAdi"),
    @NamedQuery(name = "Kitap.findByKitapaltAdi", query = "SELECT k FROM Kitap k WHERE k.kitapaltAdi = :kitapaltAdi"),
    @NamedQuery(name = "Kitap.findByKitapseriAdi", query = "SELECT k FROM Kitap k WHERE k.kitapseriAdi = :kitapseriAdi"),
    @NamedQuery(name = "Kitap.findByKitapIsbn", query = "SELECT k FROM Kitap k WHERE k.kitapIsbn = :kitapIsbn"),
    @NamedQuery(name = "Kitap.findByKitapAciklama", query = "SELECT k FROM Kitap k WHERE k.kitapAciklama = :kitapAciklama")})
public class Kitap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "kitap_id")
    private Integer kitapId;
    @Size(max = 20)
    @Column(name = "kitap_adi")
    private String kitapAdi;
    @Size(max = 20)
    @Column(name = "kitap_altAdi")
    private String kitapaltAdi;
    @Size(max = 20)
    @Column(name = "kitap_seriAdi")
    private String kitapseriAdi;
    @Size(max = 13)
    @Column(name = "kitap_isbn")
    private String kitapIsbn;
    @Size(max = 45)
    @Column(name = "kitap_aciklama")
    private String kitapAciklama;
    @JoinColumn(name = "yaz_id", referencedColumnName = "yazar_id")
    @ManyToOne
    private Yazar yazId;
    @JoinColumn(name = "yay_id", referencedColumnName = "yayinevi_id")
    @ManyToOne
    private Yayinevi yayId;

    public Kitap() {
    }

    public Kitap(Integer kitapId) {
        this.kitapId = kitapId;
    }

    public Integer getKitapId() {
        return kitapId;
    }

    public void setKitapId(Integer kitapId) {
        this.kitapId = kitapId;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKitapaltAdi() {
        return kitapaltAdi;
    }

    public void setKitapaltAdi(String kitapaltAdi) {
        this.kitapaltAdi = kitapaltAdi;
    }

    public String getKitapseriAdi() {
        return kitapseriAdi;
    }

    public void setKitapseriAdi(String kitapseriAdi) {
        this.kitapseriAdi = kitapseriAdi;
    }

    public String getKitapIsbn() {
        return kitapIsbn;
    }

    public void setKitapIsbn(String kitapIsbn) {
        this.kitapIsbn = kitapIsbn;
    }

    public String getKitapAciklama() {
        return kitapAciklama;
    }

    public void setKitapAciklama(String kitapAciklama) {
        this.kitapAciklama = kitapAciklama;
    }

    public Yazar getYazId() {
        return yazId;
    }

    public void setYazId(Yazar yazId) {
        this.yazId = yazId;
    }

    public Yayinevi getYayId() {
        return yayId;
    }

    public void setYayId(Yayinevi yayId) {
        this.yayId = yayId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kitapId != null ? kitapId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitap)) {
            return false;
        }
        Kitap other = (Kitap) object;
        if ((this.kitapId == null && other.kitapId != null) || (this.kitapId != null && !this.kitapId.equals(other.kitapId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Kitap[ kitapId=" + kitapId + " ]";
    }
    
}
