package net.leafenzo.edelwood;

import net.fabricmc.api.ClientModInitializer;
import net.leafenzo.edelwood.client.render.ModColorHandler;
import net.leafenzo.edelwood.client.render.ModRenderLayers;
import net.leafenzo.edelwood.particle.ModParticleTypes;

public class ModClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderLayers.registerBlockCutouts();
        ModColorHandler.registerBlockColorProviders();

        ModParticleTypes.registerFactoriesForClient();
    }
}
