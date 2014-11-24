/*******************************************************************************
 * This software is released under the licence CeCILL
 * 
 * see Licence_CeCILL-C_fr.html see Licence_CeCILL-C_en.html
 * 
 * see <a href="http://www.cecill.info/">http://www.cecill.info/a>
 * 
 * @copyright IGN
 ******************************************************************************/
package fr.ign.cogit.cartagen.pearep.importexport;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.geotools.data.shapefile.shp.ShapefileException;

import fr.ign.cogit.cartagen.core.genericschema.hydro.IWaterLine;
import fr.ign.cogit.cartagen.core.genericschema.land.ISimpleLandUseArea;
import fr.ign.cogit.cartagen.core.genericschema.relief.IContourLine;
import fr.ign.cogit.cartagen.core.genericschema.road.IRoadLine;
import fr.ign.cogit.cartagen.pearep.vmap.PeaRepDbType;
import fr.ign.cogit.cartagen.pearep.vmap.elev.VMAPContourLine;
import fr.ign.cogit.cartagen.pearep.vmap.hydro.VMAPWaterLine;
import fr.ign.cogit.cartagen.pearep.vmap.pop.VMAPBuiltUpArea;
import fr.ign.cogit.cartagen.pearep.vmap.transport.VMAPRoadLine;
import fr.ign.cogit.cartagen.software.CartAGenDataSet;
import fr.ign.cogit.cartagen.software.dataset.CartAGenDocOld;
import fr.ign.cogit.cartagen.software.dataset.DigitalLandscapeModel;
import fr.ign.cogit.cartagen.software.dataset.ShapeFileDB;
import fr.ign.cogit.cartagen.software.dataset.SourceDLM;
import fr.ign.cogit.cartagen.software.interfacecartagen.symbols.SymbolGroup;
import fr.ign.cogit.cartagen.software.interfacecartagen.symbols.SymbolList;
import fr.ign.cogit.cartagen.util.FileUtil;
import fr.ign.cogit.geoxygene.api.spatial.coordgeom.IPolygon;

public class VMAP0Loader extends ShapeFileLoader {

  /**
   * Default constructor
   * @param dataset
   */
  public VMAP0Loader(SymbolGroup group, String dbName) {
    createNewDb(group, dbName);
    this.setProjEpsg("32631");
  }

  @Override
  public void loadData(File directory, List<String> listLayer) throws Exception {
    // TODO Auto-generated method stub
    try {

      File shapePath;

      if (listLayer.size() == 0) {

        // ground transportation loading
        shapePath = FileUtil.getNamedFileInDir(directory, "trans");
        loadLineStringClass(FileUtil.getNamedFileInDir(shapePath, "roadl.shp")
            .getAbsolutePath(), VMAPRoadLine.class, CartAGenDataSet.ROADS_POP,
            IRoadLine.FEAT_TYPE_NAME, this.getDataset().getRoadNetwork(),
            PeaRepDbType.VMAP0);

        // hydro loading
        shapePath = FileUtil.getNamedFileInDir(directory, "hydro");
        loadLineStringClass(
            FileUtil.getNamedFileInDir(shapePath, "watrcrsl.shp")
                .getAbsolutePath(), VMAPWaterLine.class,
            CartAGenDataSet.WATER_LINES_POP, IWaterLine.FEAT_TYPE_NAME, this
                .getDataset().getHydroNetwork(), PeaRepDbType.VMAP0);

        // elevation loading
        shapePath = FileUtil.getNamedFileInDir(directory, "elev");
        loadLineStringClass(
            FileUtil.getNamedFileInDir(shapePath, "contourl.shp")
                .getAbsolutePath(), VMAPContourLine.class,
            CartAGenDataSet.CONTOUR_LINES_POP, IContourLine.FEAT_TYPE_NAME,
            null, PeaRepDbType.VMAP0);

        // population loading
        shapePath = FileUtil.getNamedFileInDir(directory, "pop");
        // loadPointClass(FileUtil.getNamedFileInDir(shapePath, "buildp.shp")
        // .getAbsolutePath(), VMAPBuildPoint.class,
        // CartAGenDataSet.BUILD_PT_POP, IBuildPoint.FEAT_TYPE_NAME,
        // PeaRepDbType.VMAP2i);
        loadPolygonClass(FileUtil.getNamedFileInDir(shapePath, "builtupa.shp")
            .getAbsolutePath(), VMAPBuiltUpArea.class,
            CartAGenDataSet.LANDUSE_AREAS_POP,
            ISimpleLandUseArea.FEAT_TYPE_NAME, PeaRepDbType.VMAP0);
      } else {

        for (String layerName : listLayer) {

          if (layerName.equals("roadl")) {
            // ground transportation loading
            shapePath = FileUtil.getNamedFileInDir(directory, "trans");
            loadLineStringClass(
                FileUtil.getNamedFileInDir(shapePath, "roadl.shp")
                    .getAbsolutePath(), VMAPRoadLine.class,
                CartAGenDataSet.ROADS_POP, IRoadLine.FEAT_TYPE_NAME, this
                    .getDataset().getRoadNetwork(), PeaRepDbType.VMAP0);
          }

          if (layerName.equals("watrcrsl")) {
            // hydro loading
            shapePath = FileUtil.getNamedFileInDir(directory, "hydro");
            loadLineStringClass(
                FileUtil.getNamedFileInDir(shapePath, "watrcrsl.shp")
                    .getAbsolutePath(), VMAPWaterLine.class,
                CartAGenDataSet.WATER_LINES_POP, IWaterLine.FEAT_TYPE_NAME,
                this.getDataset().getHydroNetwork(), PeaRepDbType.VMAP0);
          }

          if (layerName.equals("contourl")) {
            // elevation loading
            shapePath = FileUtil.getNamedFileInDir(directory, "elev");
            loadLineStringClass(
                FileUtil.getNamedFileInDir(shapePath, "contourl.shp")
                    .getAbsolutePath(), VMAPContourLine.class,
                CartAGenDataSet.CONTOUR_LINES_POP, IContourLine.FEAT_TYPE_NAME,
                null, PeaRepDbType.VMAP0);
          }

          if (layerName.equals("builtupa")) {
            // population loading
            shapePath = FileUtil.getNamedFileInDir(directory, "pop");
            // loadPointClass(FileUtil.getNamedFileInDir(shapePath,
            // "buildp.shp")
            // .getAbsolutePath(), VMAPBuildPoint.class,
            // CartAGenDataSet.BUILD_PT_POP, IBuildPoint.FEAT_TYPE_NAME,
            // PeaRepDbType.VMAP2i);
            loadPolygonClass(
                FileUtil.getNamedFileInDir(shapePath, "builtupa.shp")
                    .getAbsolutePath(), VMAPBuiltUpArea.class,
                CartAGenDataSet.LANDUSE_AREAS_POP,
                ISimpleLandUseArea.FEAT_TYPE_NAME, PeaRepDbType.VMAP0);
          }

        }

      }

    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void createNewDb(SymbolGroup group, String name) {
    // create the new CartAGen dataset
    ShapeFileDB database = new ShapeFileDB(name);
    database.setSourceDLM(SourceDLM.VMAP0);
    database.setSymboScale(500000);
    database.setOldDocument(CartAGenDocOld.getInstance());
    CartAGenDataSet dataset = new PeaRepDataset();
    dataset.setSymbols(SymbolList.getSymbolList(group));
    CartAGenDocOld.getInstance().addDatabase(name, database);
    CartAGenDocOld.getInstance().setCurrentDataset(dataset);
    database.setDataSet(dataset);
    database.setType(new DigitalLandscapeModel());
    this.setDataset(dataset);
  }

  @Override
  public void loadDataPartition(File directory, List<String> listLayer,
      IPolygon envelope) throws ShapefileException, IOException, Exception {
    // TODO Auto-generated method stub

  }

}
