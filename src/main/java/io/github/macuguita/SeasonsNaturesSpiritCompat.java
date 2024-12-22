package io.github.macuguita;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;

import io.github.lucaargolo.seasons.FabricSeasons;
import net.hibiscus.naturespirit.NatureSpirit;

public class SeasonsNaturesSpiritCompat implements ModInitializer {
	private static final String MOD_ID = "seasonsnaturesspiritcompat";

	@Override
	public void onInitialize() {
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			Version version = modContainer.getMetadata().getVersion();
			String mod = version.getFriendlyString();
			if(FabricLoader.getInstance().isModLoaded(NatureSpirit.MOD_ID)) {
				FabricSeasons.LOGGER.info("[" + FabricSeasons.MOD_NAME + "] Successfully loaded " + MOD_ID + " " + mod + " for " + NatureSpirit.MOD_ID);
			}
		});
	}
}