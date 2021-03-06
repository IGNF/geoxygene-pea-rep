/*******************************************************************************
 * This software is released under the licence CeCILL
 * 
 * see Licence_CeCILL-C_fr.html see Licence_CeCILL-C_en.html
 * 
 * see <a href="http://www.cecill.info/">http://www.cecill.info/a>
 * 
 * @copyright IGN
 ******************************************************************************/
package fr.ign.cogit.cartagen.pearep.vmap1PlusPlus;

import java.util.HashMap;

import org.hibernate.annotations.Type;

import fr.ign.cogit.cartagen.core.genericschema.network.INetworkFace;
import fr.ign.cogit.cartagen.core.genericschema.network.INetworkNode;
import fr.ign.cogit.cartagen.core.genericschema.network.INetworkSection;
import fr.ign.cogit.cartagen.core.genericschema.network.NetworkSectionType;
import fr.ign.cogit.cartagen.core.genericschema.railway.IRailwayLine;
import fr.ign.cogit.cartagen.pearep.vmap.PeaRepDbType;
import fr.ign.cogit.geoxygene.api.feature.IFeature;
import fr.ign.cogit.geoxygene.api.spatial.coordgeom.ILineString;
import fr.ign.cogit.geoxygene.schemageo.api.bati.AutreConstruction;
import fr.ign.cogit.geoxygene.schemageo.api.support.reseau.Direction;
import fr.ign.cogit.geoxygene.schemageo.impl.bati.AutreConstructionImpl;

public class VMAP1PPRailrdL extends VMAP1PPFeature implements IRailwayLine {

  private AutreConstruction geoxObj;

  // VMAP1PlusPlus attributes
  private String date_bdi, f_code, gfid_v2i, nam, src_date, src_info, txt,
      uid_, upd_date, upd_info, v2i_f_code, valid_date, valid_info, status;
  private long acc, exs, fco, fcsubtype, gaw, keep, loc, rgc, rra, rrc, rsa,
      obj_rmq, ppc, src_dim, src_name, scamax, scamin, upd_name, valid_stat,
      originform, targetscal, idapp;

  /**
   * @param type
   */
  public VMAP1PPRailrdL(ILineString lineString,
      HashMap<String, Object> attributes, PeaRepDbType type) {
    super();
    this.geoxObj = new AutreConstructionImpl(lineString);
    this.setInitialGeom(lineString);
    this.setEliminated(false);
    this.setAttributeMap(attributes);//

    this.idapp = getLongAttribute("idapp");

    this.date_bdi = getStringAttribute("date_bdi");
    this.f_code = getStringAttribute("f_code");
    this.gfid_v2i = getStringAttribute("gfid_v2i");
    this.src_date = getStringAttribute("src_date");
    this.src_info = getStringAttribute("src_info");
    this.txt = getStringAttribute("txt");
    this.uid_ = getStringAttribute("uid_");
    this.upd_date = getStringAttribute("upd_date");
    this.upd_info = getStringAttribute("upd_info");
    this.v2i_f_code = getStringAttribute("v2i_f_code");
    this.valid_date = getStringAttribute("valid_date");
    this.valid_info = getStringAttribute("valid_info");
    this.src_info = getStringAttribute("src_info");
    this.nam = getStringAttribute("nam");
    this.status = getStringAttribute("status");

    this.fcsubtype = getLongAttribute("fcsubtype");
    this.keep = getLongAttribute("keep");
    this.obj_rmq = getLongAttribute("obj_rmq");
    this.src_dim = getLongAttribute("src_dim");
    this.src_name = getLongAttribute("src_name");
    this.valid_stat = getLongAttribute("valid_stat");
    this.originform = getLongAttribute("originform");
    this.targetscal = getLongAttribute("targetscal");
    this.acc = getLongAttribute("acc");
    this.exs = getLongAttribute("exs");
    this.fco = getLongAttribute("fco");
    this.gaw = getLongAttribute("gaw");
    this.loc = getLongAttribute("loc");
    this.rgc = getLongAttribute("rgc");
    this.rra = getLongAttribute("rra");
    this.rrc = getLongAttribute("rrc");
    this.rsa = getLongAttribute("rsa");
    this.scamax = getLongAttribute("scamax");
    this.scamin = getLongAttribute("scamin");

    this.setAttributeMap(null);

  }

  @Override
  public IFeature getGeoxObj() {
    return this.geoxObj;
  }

  @Override
  @Type(type = "fr.ign.cogit.cartagen.software.interfaceCartagen.hibernate.GeOxygeneGeometryUserType")
  public ILineString getGeom() {
    return (ILineString) super.getGeom();
  }

  public String getDate_bdi() {
    return date_bdi;
  }

  public void setDate_bdi(String date_bdi) {
    this.date_bdi = date_bdi;
  }

  public String getF_code() {
    return f_code;
  }

  public void setF_code(String f_code) {
    this.f_code = f_code;
  }

  public String getGfid_v2i() {
    return gfid_v2i;
  }

  public void setGfid_v2i(String gfid_v2i) {
    this.gfid_v2i = gfid_v2i;
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

  public String getTxt() {
    return txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  public String getUid_() {
    return uid_;
  }

  public void setUid_(String uid_) {
    this.uid_ = uid_;
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

  public String getV2i_f_code() {
    return v2i_f_code;
  }

  public void setV2i_f_code(String v2i_f_code) {
    this.v2i_f_code = v2i_f_code;
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

  public long getFcsubtype() {
    return fcsubtype;
  }

  public void setFcsubtype(long fcsubtype) {
    this.fcsubtype = fcsubtype;
  }

  public long getKeep() {
    return keep;
  }

  public void setKeep(long keep) {
    this.keep = keep;
  }

  public long getObj_rmq() {
    return obj_rmq;
  }

  public void setObj_rmq(long obj_rmq) {
    this.obj_rmq = obj_rmq;
  }

  public long getSrc_dim() {
    return src_dim;
  }

  public void setSrc_dim(long src_dim) {
    this.src_dim = src_dim;
  }

  public long getSrc_name() {
    return src_name;
  }

  public void setSrc_name(long src_name) {
    this.src_name = src_name;
  }

  public long getValid_stat() {
    return valid_stat;
  }

  public void setValid_stat(long valid_stat) {
    this.valid_stat = valid_stat;
  }

  public long getUpd_name() {
    return upd_name;
  }

  public void setUpd_name(long upd_name) {
    this.upd_name = upd_name;
  }

  public long getPpc() {
    return ppc;
  }

  public void setPpc(long ppc) {
    this.ppc = ppc;
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

  public String getNam() {
    return nam;
  }

  public void setNam(String nam) {
    this.nam = nam;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public long getExs() {
    return exs;
  }

  public void setExs(long exs) {
    this.exs = exs;
  }

  public long getFco() {
    return fco;
  }

  public void setFco(long fco) {
    this.fco = fco;
  }

  public long getGaw() {
    return gaw;
  }

  public void setGaw(long gaw) {
    this.gaw = gaw;
  }

  public long getLoc() {
    return loc;
  }

  public void setLoc(long loc) {
    this.loc = loc;
  }

  public long getRgc() {
    return rgc;
  }

  public void setRgc(long rgc) {
    this.rgc = rgc;
  }

  public long getRra() {
    return rra;
  }

  public void setRra(long rra) {
    this.rra = rra;
  }

  public long getRrc() {
    return rrc;
  }

  public void setRrc(long rrc) {
    this.rrc = rrc;
  }

  public long getRsa() {
    return rsa;
  }

  public void setRsa(long rsa) {
    this.rsa = rsa;
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

  @Override
  public int getImportance() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setImportance(int importance) {
    // TODO Auto-generated method stub

  }

  @Override
  public double getWidth() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getInternWidth() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean isAnalog(INetworkSection at) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Direction getDirection() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setDirection(Direction direction) {
    // TODO Auto-generated method stub

  }

  @Override
  public INetworkNode getInitialNode() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setInitialNode(INetworkNode node) {
    // TODO Auto-generated method stub

  }

  @Override
  public INetworkNode getFinalNode() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setFinalNode(INetworkNode node) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isDeadEnd() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setDeadEnd(boolean deadEnd) {
    // TODO Auto-generated method stub

  }

  @Override
  public INetworkFace getLeftFace() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public INetworkFace getRightFace() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public NetworkSectionType getNetworkSectionType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setNetworkSectionType(NetworkSectionType type) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSidetrack(Boolean sidetrack) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isSidetrack() {
    // TODO Auto-generated method stub
    return false;
  }

  public long getAcc() {
    return acc;
  }

  public void setAcc(long acc) {
    this.acc = acc;
  }

  public long getIdapp() {
    return idapp;
  }

  public void setIdapp(long idapp) {
    this.idapp = idapp;
  }

}
