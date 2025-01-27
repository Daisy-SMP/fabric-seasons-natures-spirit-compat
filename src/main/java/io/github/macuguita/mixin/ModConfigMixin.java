package io.github.macuguita.mixin;

import io.github.lucaargolo.seasons.utils.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ModConfig.class)
public class ModConfigMixin {

    /**
     * Inject into the class constructor to modify the biomeForceSnowInWinterList field.
     */
    @Inject(
            method = "Lio/github/lucaargolo/seasons/utils/ModConfig;<init>()V", // Fully qualified constructor name
            at = @At("TAIL")
    )
    private void onInit(CallbackInfo ci) {
        // Use reflection to access the private field
        try {
            // Get the private field
            var field = ModConfig.class.getDeclaredField("biomeForceSnowInWinterList");
            field.setAccessible(true);

            // Define your custom biome list
            List<String> customBiomeList = List.of(
                    "minecraft:plains",
                    "minecraft:sunflower_plains",
                    "minecraft:stony_peaks",
                    "natures_spirit:sugi_forest",
                    "natures_spirit:windswpt_sugi_forest",
                    "natures_spirit:blooming_sugi_forest"
            );

            // Set the field to the custom list
            field.set(this, customBiomeList);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}