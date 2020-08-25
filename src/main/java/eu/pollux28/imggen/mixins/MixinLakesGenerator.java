package eu.pollux28.imggen.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(LakeFeature.class)
public class MixinLakesGenerator {
    @Inject(method = "generate", at = @At("HEAD"),cancellable = true)
    private void injectLessLakes(ServerWorldAccess serverWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, SingleStateFeatureConfig singleStateFeatureConfig, CallbackInfoReturnable<Boolean> cir){
        if (random.nextFloat() <0.5f){
            cir.setReturnValue(false);
        }
    }
}
