/*******************************************************************************
 * This software is released under the licence CeCILL
 * 
 * see Licence_CeCILL-C_fr.html see Licence_CeCILL-C_en.html
 * 
 * see <a href="http://www.cecill.info/">http://www.cecill.info/a>
 * 
 * @copyright IGN
 ******************************************************************************/
package fr.ign.cogit.cartagen.pearep.mgcp.hydro;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import fr.ign.cogit.cartagen.core.genericschema.hydro.IWaterArea;
import fr.ign.cogit.cartagen.pearep.mgcp.MGCPFeature;
import fr.ign.cogit.cartagen.pearep.vmap.PeaRepDbType;
import fr.ign.cogit.geoxygene.api.feature.IFeature;
import fr.ign.cogit.geoxygene.api.spatial.coordgeom.IPolygon;
import fr.ign.cogit.geoxygene.schemageo.api.hydro.SurfaceDEau;
import fr.ign.cogit.geoxygene.schemageo.impl.hydro.SurfaceDEauImpl;
import fr.ign.cogit.geoxygene.schemageo.impl.support.reseau.ReseauImpl;

/*
 * ###### IGN / CartAGen ###### Title: WaterArea Description: Surfaces d'eau
 * Author: J. Renard Date: 18/09/2009
 */
public class MGCPLakeArea extends MGCPFeature implements IWaterArea {

  /**
   * Associated Geoxygene schema object
   */
  private SurfaceDEau geoxObj;
  private String name;

  // VMAP attributes
  // MGCP attributes
  private long acc, ace_eval, ale_eval, ari, fcsubtype, hyp, prc, scc, smc,
      src_name, upd_name, valid_stat, zval_type, scamax, scamin, originform,
      targetscal;
  private String ace, ale, cpyrt_note, date_bdi, nam, nfi, nfn, src_date,
      src_info, tier_note, txt, uid, upd_date, upd_info, valid_date,
      valid_info;
  private double length, width;
  private WaterAreaNature type = WaterAreaNature.RIVER;

  /**
   * Cosntructor from lakeresa class from VMAP2i model
   * @param type
   */
  public MGCPLakeArea(IPolygon poly, HashMap<String, Object> attributes,
      PeaRepDbType type) {
    super();
    this.geoxObj = new SurfaceDEauImpl();
    this.geoxObj.setGeom(poly);
    this.setInitialGeom(poly);
    this.setEliminated(false);
    this.setAttributeMap(attributes);//

    // attributes present in Mgcp++
    this.acc = getLongAttribute("acc");
    this.ace_eval = getLongAttribute("ace_eval");
    this.ale_eval = getLongAttribute("ale_eval");
    this.ari = getLongAttribute("ari");
    this.fcsubtype = getLongAttribute("fcsubtype");
    this.hyp = getLongAttribute("hyp");
    this.prc = getLongAttribute("prc");
    if (attributes.containsKey("scc")) {
      this.scc = getLongAttribute("scc");
      this.setType(WaterAreaNature.LAKE);
    }
    this.smc = getLongAttribute("smc");
    this.src_name = getLongAttribute("src_name");
    this.upd_name = getLongAttribute("upd_name");
    this.valid_stat = getLongAttribute("valid_stat");
    this.zval_type = getLongAttribute("zval_type");
    this.scamax = getLongAttribute("scamax");
    this.scamin = getLongAttribute("scamin");
    this.originform = getLongAttribute("originform");
    this.targetscal = getLongAttribute("targetscal");

    this.ace = getStringAttribute("ace");
    this.ale = getStringAttribute("ale");
    this.cpyrt_note = getStringAttribute("cpyrt_note");
    this.date_bdi = getStringAttribute("date_bdi");
    this.nam = getStringAttribute("nam");
    this.name = getStringAttribute("nam");
    this.nfi = getStringAttribute("nfi");
    this.nfn = getStringAttribute("nfn");
    this.src_date = getStringAttribute("src_date");
    this.src_info = getStringAttribute("src_info");
    this.tier_note = getStringAttribute("tier_note");
    this.txt = getStringAttribute("txt");
    this.uid = getStringAttribute("uid");
    this.upd_date = getStringAttribute("upd_date");
    this.upd_info = getStringAttribute("upd_info");
    this.valid_date = getStringAttribute("valid_date");
    this.valid_info = getStringAttribute("valid_info");
    this.setAttributeMap(null);
    // computeLengthWidth();
  }

  /**
   * Compute the length of the water area using its skeleton and its width
   * divising the area by the computed length.
   */
  @SuppressWarnings("unused")
  private void computeLengthWidth() {
    // TODO
  }

  /**
   * Default constructor, used by Hibernate.
   */
  public MGCPLakeArea() {
    super();
  }

  @Override
  @Transient
  public IFeature getGeoxObj() {
    return this.geoxObj;
  }

  @Override
  @Type(type = "fr.ign.cogit.cartagen.software.interfaceCartagen.hibernate.GeOxygeneGeometryUserType")
  public IPolygon getGeom() {
    return (IPolygon) super.getGeom();
  }

  @Override
  @Column(name = "CartAGenDB_name")
  public String getDbName() {
    return super.getDbName();
  }

  @Override
  @Id
  public int getId() {
    return super.getId();
  }

  @Override
  public boolean isEliminated() {
    return super.isEliminated();
  }

  @Override
  public int getSymbolId() {
    return super.getSymbolId();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public long getPrc() {
    return this.prc;
  }

  public void setPrc(long prc) {
    this.prc = prc;
  }

  public long getSmc() {
    return this.smc;
  }

  public void setSmc(long smc) {
    this.smc = smc;
  }

  public long getScc() {
    return this.scc;
  }

  public void setScc(long scc) {
    this.scc = scc;
  }

  public String getNfi() {
    return this.nfi;
  }

  public void setNfi(String nfi) {
    this.nfi = nfi;
  }

  public String getNfn() {
    return this.nfn;
  }

  public void setNfn(String nfn) {
    this.nfn = nfn;
  }

  @Override
  public void restoreGeoxObjects() {
    this.geoxObj = new SurfaceDEauImpl(new ReseauImpl(), this.getGeom());
    this.geoxObj.setNom(this.name);
  }

  /**
   * Useful to query on feature area.
   * @return
   */
  public double getArea() {
    return this.getGeom().area();
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getLength() {
    return this.length;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getWidth() {
    return this.width;
  }

  public long getAcc() {
    return this.acc;
  }

  public void setAcc(long acc) {
    this.acc = acc;
  }

  public long getHyp() {
    return this.hyp;
  }

  public void setHyp(long hyp) {
    this.hyp = hyp;
  }

  public WaterAreaNature getType() {
    return type;
  }

  public void setType(WaterAreaNature type) {
    this.type = type;
  }

  public long getAce_eval() {
    return ace_eval;
  }

  public void setAce_eval(long ace_eval) {
    this.ace_eval = ace_eval;
  }

  public long getAle_eval() {
    return ale_eval;
  }

  public void setAle_eval(long ale_eval) {
    this.ale_eval = ale_eval;
  }

  public long getAri() {
    return ari;
  }

  public void setAri(long ari) {
    this.ari = ari;
  }

  public long getFcsubtype() {
    return fcsubtype;
  }

  public void setFcsubtype(long fcsubtype) {
    this.fcsubtype = fcsubtype;
  }

  public long getSrc_name() {
    return src_name;
  }

  public void setSrc_name(long src_name) {
    this.src_name = src_name;
  }

  public long getUpd_name() {
    return upd_name;
  }

  public void setUpd_name(long upd_name) {
    this.upd_name = upd_name;
  }

  public long getValid_stat() {
    return valid_stat;
  }

  public void setValid_stat(long valid_stat) {
    this.valid_stat = valid_stat;
  }

  public long getZval_type() {
    return zval_type;
  }

  public void setZval_type(long zval_type) {
    this.zval_type = zval_type;
  }

  public long getScamax() {
    return scamax;
  }

  public void setScamax(long scamax) {
    this.scamax = scamax;
  }

  public long getScamin() {
    return scamin;
  }

  public void setScamin(long scamin) {
    this.scamin = scamin;
  }

  public long getOriginform() {
    return originform;
  }

  public void setOriginform(long originform) {
    this.originform = originform;
  }

  public long getTargetscal() {
    return targetscal;
  }

  public void setTargetscal(long targetscal) {
    this.targetscal = targetscal;
  }

  public String getAce() {
    return ace;
  }

  public void setAce(String ace) {
    this.ace = ace;
  }

  public String getAle() {
    return ale;
  }

  public void setAle(String ale) {
    this.ale = ale;
  }

  public String getCpyrt_note() {
    return cpyrt_note;
  }

  public void setCpyrt_note(String cpyrt_note) {
    this.cpyrt_note = cpyrt_note;
  }

  public String getDate_bdi() {
    return date_bdi;
  }

  public void setDate_bdi(String date_bdi) {
    this.date_bdi = date_bdi;
  }

  public String getNam() {
    return nam;
  }

  public void setNam(String nam) {
    this.nam = nam;
  }

  public String getSrc_date() {
    return src_date;
  }

  public void setSrc_date(String src_date) {
    this.src_date = src_date;
  }

  public String getSrc_info() {
    return src_info;
  }

  public void setSrc_info(String src_info) {
    this.src_info = src_info;
  }

  public String getTier_note() {
    return tier_note;
  }

  public void setTier_note(String tier_note) {
    this.tier_note = tier_note;
  }

  public String getTxt() {
    return txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getUpd_date() {
    return upd_date;
  }

  public void setUpd_date(String upd_date) {
    this.upd_date = upd_date;
  }

  public String getUpd_info() {
    return upd_info;
  }

  public void setUpd_info(String upd_info) {
    this.upd_info = upd_info;
  }

  public String getValid_date() {
    return valid_date;
  }

  public void setValid_date(String valid_date) {
    this.valid_date = valid_date;
  }

  public String getValid_info() {
    return valid_info;
  }

  public void setValid_info(String valid_info) {
    this.valid_info = valid_info;
  }

  @Override
  public WaterAreaNature getNature() {
    return type;
  }
}
