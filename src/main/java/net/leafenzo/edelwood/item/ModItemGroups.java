package net.leafenzo.edelwood.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.edelwood.ModInit;
import net.leafenzo.edelwood.Super;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static void registerModItemGroups() {
        ModInit.LOGGER.debug("Registering item groups for " + Super.MOD_ID);
    }

//    public static ItemGroup EDELWOOD = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "edelwood"),
//            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.edelwood"))
//                    .icon(() -> new ItemStack(Blocks.AIR)).entries((displayContext, entries) -> {
//                     //entries.add(ModBlocks.);
//                    }).build());
}
