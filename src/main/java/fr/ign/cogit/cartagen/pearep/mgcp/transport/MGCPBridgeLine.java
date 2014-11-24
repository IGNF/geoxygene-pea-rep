package fr.ign.cogit.cartagen.pearep.mgcp.transport;

import java.util.HashMap;

import org.hibernate.annotations.Type;

import fr.ign.cogit.cartagen.core.genericschema.hydro.IWaterArea;
import fr.ign.cogit.cartagen.core.genericschema.network.INetworkSection;
import fr.ign.cogit.cartagen.core.genericschema.road.IBridgeLine;
import fr.ign.cogit.cartagen.pearep.mgcp.MGCPFeature;
import fr.ign.cogit.cartagen.pearep.vmap.PeaRepDbType;
import fr.ign.cogit.geoxygene.api.spatial.coordgeom.ILineString;

public class MGCPBridgeLine extends MGCPFeature implements IBridgeLine {

  private BridgeType type;
  private IWaterArea crossedArea;
  private INetworkSection crossedSection, containingSection;
  private String upd_date, upd_info, cpyrt_note, src_info, txt, nfi, nfn,
      tier_note, nam, src_date, ace, ale, nos, wid, lc1, lc3, lc2, lc4, wd1,
      voi, hca, mvc, ohb;
  private long acc, ace_eval, ale_eval, uid, upd_name, src_name, zval_type,
      trs, rst, bsc, bot, smc, fun;

  /**
   * @param type
   */
  public MGCPBridgeLine(ILineString line, HashMap<String, Object> attributes,
      PeaRepDbType type) {
    super();
    this.setGeom(line);
    this.setInitialGeom(line);
    this.setEliminated(false);
    this.setAttributeMap(attributes);//

    // attributes present in Mgcp++
    this.acc = getLongAttribute("acc");
    this.ace_eval = getLongAttribute("ace_eval");
    this.ale_eval = getLongAttribute("ale_eval");
    if (attributes.containsKey("uid"))
      this.uid = getLongAttribute("uid");
    this.src_name = getLongAttribute("src_name");
    this.zval_type = getLongAttribute("zval_type");
    this.trs = getLongAttribute("trs");
    if (attributes.containsKey("nos")) {
      this.nos = getStringAttribute("nos");
      this.type = BridgeType.BRIDGE;
    }
    if (attributes.containsKey("rst")) {
      this.rst = getLongAttribute("rst");
      this.type = BridgeType.FORD;
    }
    if (attributes.containsKey("bsc"))
      this.bsc = getLongAttribute("bsc");
    if (attributes.containsKey("bot"))
      this.bot = getLongAttribute("bot");
    if (attributes.containsKey("smc"))
      this.smc = getLongAttribute("smc");
    if (attributes.containsKey("fun"))
      this.fun = getLongAttribute("fun");
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
    if (attributes.containsKey("wid"))
      this.wid = getStringAttribute("wid");
    if (attributes.containsKey("lc1"))
      this.lc1 = getStringAttribute("lc1");
    if (attributes.containsKey("lc2"))
      this.lc2 = getStringAttribute("lc2");
    if (attributes.containsKey("lc3"))
      this.lc3 = getStringAttribute("lc3");
    if (attributes.containsKey("lc4"))
      this.lc4 = getStringAttribute("lc4");
    if (attributes.containsKey("voi"))
      this.voi = getStringAttribute("voi");
    if (attributes.containsKey("wd1"))
      this.wd1 = getStringAttribute("wd1");
    if (attributes.containsKey("hca"))
      this.hca = getStringAttribute("hca");
    if (attributes.containsKey("mvc"))
      this.mvc = getStringAttribute("mvc");
    if (attributes.containsKey("ohb"))
      this.ohb = getStringAttribute("ohb");
    this.setAttributeMap(null);
  }

  @Override
  @Type(type = "fr.ign.cogit.cartagen.software.interfaceCartagen.hibernate.GeOxygeneGeometryUserType")
  public ILineString getGeom() {
    return (ILineString) super.getGeom();
  }

  @Override
  public BridgeType getType() {
    return type;
  }

  @Override
  public IWaterArea getCrossedArea() {
    return crossedArea;
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

  public String getNos() {
    return nos;
  }

  public void setNos(String nos) {
    this.nos = nos;
  }

  public String getWid() {
    return wid;
  }

  public void setWid(String wid) {
    this.wid = wid;
  }

  public String getLc1() {
    return lc1;
  }

  public void setLc1(String lc1) {
    this.lc1 = lc1;
  }

  public String getLc3() {
    return lc3;
  }

  public void setLc3(String lc3) {
    this.lc3 = lc3;
  }

  public String getLc2() {
    return lc2;
  }

  public void setLc2(String lc2) {
    this.lc2 = lc2;
  }

  public String getLc4() {
    return lc4;
  }

  public void setLc4(String lc4) {
    this.lc4 = lc4;
  }

  public String getWd1() {
    return wd1;
  }

  public void setWd1(String wd1) {
    this.wd1 = wd1;
  }

  public String getVoi() {
    return voi;
  }

  public void setVoi(String voi) {
    this.voi = voi;
  }

  public String getHca() {
    return hca;
  }

  public void setHca(String hca) {
    this.hca = hca;
  }

  public String getMvc() {
    return mvc;
  }

  public void setMvc(String mvc) {
    this.mvc = mvc;
  }

  public String getOhb() {
    return ohb;
  }

  public void setOhb(String ohb) {
    this.ohb = ohb;
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

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
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

  public long getTrs() {
    return trs;
  }

  public void setTrs(long trs) {
    this.trs = trs;
  }

  public long getRst() {
    return rst;
  }

  public void setRst(long rst) {
    this.rst = rst;
  }

  public long getBsc() {
    return bsc;
  }

  public void setBsc(long bsc) {
    this.bsc = bsc;
  }

  public long getBot() {
    return bot;
  }

  public void setBot(long bot) {
    this.bot = bot;
  }

  public long getSmc() {
    return smc;
  }

  public void setSmc(long smc) {
    this.smc = smc;
  }

  public long getFun() {
    return fun;
  }

  public void setFun(long fun) {
    this.fun = fun;
  }

  public void setType(BridgeType type) {
    this.type = type;
  }

  public void setCrossedArea(IWaterArea crossedArea) {
    this.crossedArea = crossedArea;
  }

  @Override
  public INetworkSection getCrossedNetwork() {
    return crossedSection;
  }

  @Override
  public void setCrossedNetwork(INetworkSection section) {
    this.crossedSection = section;
  }

  @Override
  public INetworkSection getContainingNetwork() {
    return containingSection;
  }

  @Override
  public void setContainingNetwork(INetworkSection section) {
    this.containingSection = section;
  }

}
