package fr.ign.cogit.cartagen.pearep.mgcp.hydro;

import java.util.HashMap;

import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import fr.ign.cogit.cartagen.core.genericschema.hydro.ICoastLine;
import fr.ign.cogit.cartagen.pearep.mgcp.MGCPFeature;
import fr.ign.cogit.cartagen.pearep.vmap.PeaRepDbType;
import fr.ign.cogit.geoxygene.api.feature.IFeature;
import fr.ign.cogit.geoxygene.api.spatial.coordgeom.ILineString;
import fr.ign.cogit.geoxygene.schemageo.api.hydro.TronconLaisse;
import fr.ign.cogit.geoxygene.schemageo.api.hydro.TronconLaisse.HauteurLaisse;
import fr.ign.cogit.geoxygene.schemageo.impl.hydro.TronconLaisseImpl;
import fr.ign.cogit.geoxygene.schemageo.impl.support.reseau.ReseauImpl;

public class MGCPCoastLine extends MGCPFeature implements ICoastLine {

  private TronconLaisse geoxObj;

  private long acc, ace_eval, ale_eval, asc, exs, fcsubtype, hyp, slt,
      src_name, upd_name, valid_stat, vdc, zval_type, scamax, scamin,
      originform, targetscal;

  private String ace, ale, cpyrt_note, date_bdi, nam, nfi, nfn, rbv, src_date,
      src_info, tier_note, txt, uid, upd_date, upd_info, valid_date,
      valid_info;

  /**
   * @param type
   */
  public MGCPCoastLine(ILineString line, HashMap<String, Object> attributes,
      PeaRepDbType type) {
    super();
    this.setGeoxObj(new TronconLaisseImpl(new ReseauImpl(), false, line,
        HauteurLaisse.BASSE_MER));
    this.setInitialGeom(line);
    this.setEliminated(false);
    this.setAttributeMap(attributes);//

    // attributes present in Mgcp++
    this.acc = getLongAttribute("acc");
    this.ace_eval = getLongAttribute("ace_eval");
    this.ale_eval = getLongAttribute("ale_eval");
    if (attributes.containsKey("asc"))
      this.asc = getLongAttribute("asc");
    this.exs = getLongAttribute("exs");
    this.fcsubtype = getLongAttribute("fcsubtype");
    this.hyp = getLongAttribute("hyp");
    this.valid_stat = getLongAttribute("valid_stat");
    this.vdc = getLongAttribute("vdc");
    if (attributes.containsKey("uid"))
      this.uid = getStringAttribute("uid");
    this.src_name = getLongAttribute("src_name");
    this.zval_type = getLongAttribute("zval_type");
    this.slt = getLongAttribute("slt");

    this.upd_date = getStringAttribute("upd_date");
    this.upd_info = getStringAttribute("upd_info");
    this.cpyrt_note = getStringAttribute("cpyrt_note");
    this.upd_name = getLongAttribute("upd_name");
    this.src_info = getStringAttribute("src_info");
    this.txt = getStringAttribute("txt");
    this.nfi = getStringAttribute("nfi");
    this.nfn = getStringAttribute("nfn");
    this.tier_note = getStringAttribute("tier_note");
    this.nam = getStringAttribute("nam");
    this.src_date = getStringAttribute("src_date");
    this.ace = getStringAttribute("ace");
    this.ale = getStringAttribute("ale");
    this.date_bdi = getStringAttribute("date_bdi");
    this.rbv = getStringAttribute("rbv");
    this.valid_date = getStringAttribute("valid_date");
    this.valid_info = getStringAttribute("valid_info");

    this.setAttributeMap(null);
  }

  private void setGeoxObj(TronconLaisse elementIsole) {
    this.geoxObj = elementIsole;
  }

  @Override
  @Transient
  public IFeature getGeoxObj() {
    return this.geoxObj;
  }

  @Override
  @Type(type = "fr.ign.cogit.cartagen.software.interfaceCartagen.hibernate.GeOxygeneGeometryUserType")
  public ILineString getGeom() {
    return (ILineString) super.getGeom();
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

  public String getCpyrt_note() {
    return cpyrt_note;
  }

  public void setCpyrt_note(String cpyrt_note) {
    this.cpyrt_note = cpyrt_note;
  }

  public String getSrc_info() {
    return src_info;
  }

  public void setSrc_info(String src_info) {
    this.src_info = src_info;
  }

  public String getTxt() {
    return txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  public String getNfi() {
    return nfi;
  }

  public void setNfi(String nfi) {
    this.nfi = nfi;
  }

  public String getNfn() {
    return nfn;
  }

  public void setNfn(String nfn) {
    this.nfn = nfn;
  }

  public String getTier_note() {
    return tier_note;
  }

  public void setTier_note(String tier_note) {
    this.tier_note = tier_note;
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

  public long getAcc() {
    return acc;
  }

  public void setAcc(long acc) {
    this.acc = acc;
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

  public long getUpd_name() {
    return upd_name;
  }

  public void setUpd_name(long upd_name) {
    this.upd_name = upd_name;
  }

  public long getSrc_name() {
    return src_name;
  }

  public void setSrc_name(long src_name) {
    this.src_name = src_name;
  }

  public long getZval_type() {
    return zval_type;
  }

  public void setZval_type(long zval_type) {
    this.zval_type = zval_type;
  }

  public long getAsc() {
    return asc;
  }

  public void setAsc(long asc) {
    this.asc = asc;
  }

  public long getSlt() {
    return slt;
  }

  public void setSlt(long slt) {
    this.slt = slt;
  }

  public long getExs() {
    return exs;
  }

  public void setExs(long exs) {
    this.exs = exs;
  }

  public long getFcsubtype() {
    return fcsubtype;
  }

  public void setFcsubtype(long fcsubtype) {
    this.fcsubtype = fcsubtype;
  }

  public long getHyp() {
    return hyp;
  }

  public void setHyp(long hyp) {
    this.hyp = hyp;
  }

  public long getValid_stat() {
    return valid_stat;
  }

  public void setValid_stat(long valid_stat) {
    this.valid_stat = valid_stat;
  }

  public long getVdc() {
    return vdc;
  }

  public void setVdc(long vdc) {
    this.vdc = vdc;
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

  public String getDate_bdi() {
    return date_bdi;
  }

  public void setDate_bdi(String date_bdi) {
    this.date_bdi = date_bdi;
  }

  public String getRbv() {
    return rbv;
  }

  public void setRbv(String rbv) {
    this.rbv = rbv;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
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

}
