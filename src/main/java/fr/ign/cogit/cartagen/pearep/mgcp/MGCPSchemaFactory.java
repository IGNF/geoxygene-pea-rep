/*******************************************************************************
 * This software is released under the licence CeCILL
 * 
 * see Licence_CeCILL-C_fr.html see Licence_CeCILL-C_en.html
 * 
 * see <a href="http://www.cecill.info/">http://www.cecill.info/a>
 * 
 * @copyright IGN
 ******************************************************************************/
package fr.ign.cogit.cartagen.pearep.mgcp;

import java.util.Collection;

import fr.ign.cogit.cartagen.core.defaultschema.network.Network;
import fr.ign.cogit.cartagen.core.defaultschema.relief.ReliefField;
import fr.ign.cogit.cartagen.core.defaultschema.road.BranchingCrossRoad;
import fr.ign.cogit.cartagen.core.defaultschema.road.RoundAbout;
import fr.ign.cogit.cartagen.core.genericschema.AbstractCreationFactory;
import fr.ign.cogit.cartagen.core.genericschema.airport.IAirportArea;
import fr.ign.cogit.cartagen.core.genericschema.airport.IRunwayArea;
import fr.ign.cogit.cartagen.core.genericschema.airport.IRunwayLine;
import fr.ign.cogit.cartagen.core.genericschema.airport.ITaxiwayArea;
import fr.ign.cogit.cartagen.core.genericschema.airport.ITaxiwayArea.TaxiwayType;
import fr.ign.cogit.cartagen.core.genericschema.airport.ITaxiwayLine;
import fr.ign.cogit.cartagen.core.genericschema.energy.IElectricityLine;
import fr.ign.cogit.cartagen.core.genericschema.hydro.IWaterNode;
import fr.ign.cogit.cartagen.core.genericschema.network.INetwork;
import fr.ign.cogit.cartagen.core.genericschema.network.INetworkNode;
import fr.ign.cogit.cartagen.core.genericschema.railway.IRailwayLine;
import fr.ign.cogit.cartagen.core.genericschema.railway.IRailwayNode;
import fr.ign.cogit.cartagen.core.genericschema.relief.IReliefField;
import fr.ign.cogit.cartagen.core.genericschema.road.IBranchingCrossroad;
import fr.ign.cogit.cartagen.core.genericschema.road.IBridgePoint;
import fr.ign.cogit.cartagen.core.genericschema.road.IRoadLine;
import fr.ign.cogit.cartagen.core.genericschema.road.IRoadNode;
import fr.ign.cogit.cartagen.core.genericschema.road.IRoundAbout;
import fr.ign.cogit.cartagen.pearep.mgcp.aer.MGCPAirport;
import fr.ign.cogit.cartagen.pearep.mgcp.aer.MGCPAirportPoint;
import fr.ign.cogit.cartagen.pearep.mgcp.aer.MGCPRunwayArea;
import fr.ign.cogit.cartagen.pearep.mgcp.aer.MGCPRunwayLine;
import fr.ign.cogit.cartagen.pearep.mgcp.aer.MGCPTaxiwayArea;
import fr.ign.cogit.cartagen.pearep.mgcp.aer.MGCPTaxiwayLine;
import fr.ign.cogit.cartagen.pearep.mgcp.energy.MGCPElectricityLine;
import fr.ign.cogit.cartagen.pearep.mgcp.hydro.MGCPWaterNode;
import fr.ign.cogit.cartagen.pearep.mgcp.sea.MGCPShipWreckArea;
import fr.ign.cogit.cartagen.pearep.mgcp.transport.MGCPBridgePoint;
import fr.ign.cogit.cartagen.pearep.mgcp.transport.MGCPRailwayLine;
import fr.ign.cogit.cartagen.pearep.mgcp.transport.MGCPRailwayNode;
import fr.ign.cogit.cartagen.pearep.mgcp.transport.MGCPRoadNode;
import fr.ign.cogit.cartagen.spatialanalysis.network.roads.PatteOie;
import fr.ign.cogit.cartagen.spatialanalysis.network.roads.RondPoint;
import fr.ign.cogit.geoxygene.api.spatial.coordgeom.ILineString;
import fr.ign.cogit.geoxygene.api.spatial.coordgeom.IPolygon;
import fr.ign.cogit.geoxygene.api.spatial.geomprim.IPoint;
import fr.ign.cogit.geoxygene.contrib.cartetopo.Noeud;
import fr.ign.cogit.geoxygene.schemageo.api.support.champContinu.ChampContinu;
import fr.ign.cogit.geoxygene.schemageo.api.support.reseau.Reseau;

public class MGCPSchemaFactory extends AbstractCreationFactory {

  @Override
  public IRoadNode createRoadNode(Noeud noeud) {
    return new MGCPRoadNode(noeud);
  }

  public IRoadNode createRoadNode(IPoint point) {
    return new MGCPRoadNode(point);
  }

  @Override
  public IReliefField createReliefField(ChampContinu champ) {
    return new ReliefField(champ);
  }

  @Override
  public INetwork createNetwork() {
    return new Network();
  }

  @Override
  public INetwork createNetwork(Reseau res) {
    return new Network(res);
  }

  @Override
  public IAirportArea createAirportArea(IPolygon geom) {
    return new MGCPAirport(geom);
  }

  @Override
  public IRunwayArea createRunwayArea(IPolygon geom) {
    return new MGCPRunwayArea(geom);
  }

  @Override
  public IRunwayLine createRunwayLine(ILineString geom) {
    return new MGCPRunwayLine(geom);
  }

  @Override
  public ITaxiwayLine createTaxiwayLine(ILineString geom, TaxiwayType type) {
    return new MGCPTaxiwayLine(geom, type);
  }

  @Override
  public ITaxiwayArea createTaxiwayArea(IPolygon geom, TaxiwayType type) {
    return new MGCPTaxiwayArea(geom, type);
  }

  public MGCPAirportPoint createAirportPoint(IPoint geom) {
    return new MGCPAirportPoint(geom);
  }

  @Override
  public IBridgePoint createBridgePoint(IPoint point) {
    return new MGCPBridgePoint(point);
  }

  @Override
  public IWaterNode createWaterNode(Noeud noeud) {
    return new MGCPWaterNode(noeud);
  }

  @Override
  public IRailwayNode createRailwayNode(Noeud noeud) {
    return new MGCPRailwayNode(noeud);
  }

  public MGCPShipWreckArea createAirportPoint(IPolygon geom) {
    return new MGCPShipWreckArea(geom);
  }

  @Override
  public IElectricityLine createElectricityLine(ILineString line, int importance) {
    return new MGCPElectricityLine(line, importance);
  }

  // BranchingCrossroad

  @Override
  public IBranchingCrossroad createBranchingCrossroad() {
    return new BranchingCrossRoad();
  }

  @Override
  public IBranchingCrossroad createBranchingCrossroad(PatteOie geoxObj,
      Collection<IRoadLine> roads, Collection<IRoadNode> nodes) {
    return new BranchingCrossRoad(geoxObj, roads, nodes);
  }

  // RoundAbout

  @Override
  public IRoundAbout createRoundAbout() {
    return new RoundAbout();
  }

  @Override
  public IRoundAbout createRoundAbout(RondPoint geoxObj,
      Collection<IRoadLine> roads, Collection<IRoadNode> nodes) {
    return new RoundAbout(geoxObj, roads, nodes);
  }

  @Override
  public IRoundAbout createRoundAbout(IPolygon geom,
      Collection<IRoadLine> externalRoads, Collection<IRoadLine> internalRoads,
      Collection<INetworkNode> initialNodes) {
    return new RoundAbout(geom, externalRoads, internalRoads, initialNodes);
  }

  @Override
  public IRailwayLine createRailwayLine(ILineString line, int importance) {
    IRailwayLine rail = new MGCPRailwayLine(line);
    rail.setImportance(importance);
    return rail;
  }

}
