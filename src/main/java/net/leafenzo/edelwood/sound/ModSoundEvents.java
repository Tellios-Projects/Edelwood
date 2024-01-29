package net.leafenzo.edelwood.sound;

import net.leafenzo.edelwood.ModInit;
import net.leafenzo.edelwood.Super;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent BLOCK_EDELWOOD_COUGH = registerSoundEvent("block.edelwood.cough");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Super.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSoundEvents() {
        ModInit.LOGGER.debug("Registering sound events for " + Super.MOD_ID);
    }
}
