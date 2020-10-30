package eu.pollux28.imggen.config;
//Code used from Simplex Terrain <https://github.com/SuperCoder7979/simplexterrain>, with permission from SuperCoder79
import eu.pollux28.imggen.ImgGen;
import eu.pollux28.imggen.util.BiomeIDAndRGBPair;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainConfigData {
    public String configVersion = ImgGen.VERSION;
    public String imageName="defaultImage.png";
    public double scale = 1.0;
    public String defaultBiome="minecraft:ocean";

    public List<BiomeIDAndRGBPair> customBiomes = Arrays.asList(new BiomeIDAndRGBPair("modid:biomeid","0x000000"),new BiomeIDAndRGBPair("modid:biomeid","0xFFFFFF"));
    public float lakeFormationPercentChance = 0.5f;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainConfigData that = (MainConfigData) o;
        return Double.compare(that.scale, scale) == 0 &&
                Float.compare(that.lakeFormationPercentChance, lakeFormationPercentChance) == 0 &&
                configVersion.equals(that.configVersion) &&
                imageName.equals(that.imageName) &&
                (defaultBiome.equals(that.defaultBiome)) &&
                customBiomes== that.customBiomes;

    }

    @Override
    public int hashCode() {
        return Objects.hash(configVersion, imageName, defaultBiome, scale, customBiomes, lakeFormationPercentChance);
    }
}
