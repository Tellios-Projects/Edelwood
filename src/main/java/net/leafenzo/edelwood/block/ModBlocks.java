package net.leafenzo.edelwood.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.leafenzo.edelwood.ModInit;
import net.leafenzo.edelwood.Super;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class ModBlocks {
    //public static final Block BLAZE_ROD_BLOCK = registerBlock("blaze_rod_block", new ReversiblePillarBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.TERRACOTTA_YELLOW).requiresTool().strength(2.0f).sounds(ModBlockSoundGroup.BLAZE_ROD_BLOCK).luminance(state -> 7)),ModItemGroups.SQUASHED);

//    public static final Block
//    public static final WoodType EDELWOOD
//    public static WoodSet RegisterWoodset(String name) {
//    }

    public static final Block OILY_EDELWOOD = registerBlock("oily_edelwood", new OilyEdelwoodBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_WOOD)));

//    public static WoodSet EDELWOOD_WOODSET = registerEdelWoodSet();
//    public static WoodSet registerEdelWoodSet() {
//        String name = "edelwood";
//        WoodSetBuilder builder = new WoodSetBuilder();
//        builder.setLog();
//    }
//
//    public class WoodSet {
//        @Nullable public final Block LOG;
//        @Nullable public final Block WOOD;
//        @Nullable public final Block STRIPPED_LOG;
//        @Nullable public final Block STRIPPED_WOOD;
//        @Nullable public final Block PLANKS;
//        @Nullable public final Block STAIRS;
//        @Nullable public final Block SLAB;
//        @Nullable public final Block FENCE;
//        @Nullable public final Block FENCE_GATE;
//        @Nullable public final Block DOOR;
//        @Nullable public final Block TRAPDOOR;
//        @Nullable public final Block PRESSURE_PLATE;
//        @Nullable public final Block BUTTON;
//
//        public WoodSet(WoodSetBuilder builder) {
//            this.LOG = builder.LOG;
//            this.WOOD = builder.WOOD;
//            this.STRIPPED_LOG = builder.STRIPPED_LOG;
//            this.STRIPPED_WOOD = builder.STRIPPED_WOOD;
//            this.PLANKS = builder.PLANKS;
//            this.STAIRS = builder.STAIRS;
//            this.SLAB = builder.SLAB;
//            this.FENCE = builder.FENCE;
//            this.FENCE_GATE = builder.FENCE_GATE;
//            this.DOOR = builder.DOOR;
//            this.TRAPDOOR = builder.TRAPDOOR;
//            this.PRESSURE_PLATE = builder.PRESSURE_PLATE;
//            this.BUTTON = builder.BUTTON;
//        }
//    }
//    public class WoodSetBuilder {
//        private Block LOG;
//        private Block WOOD;
//        private Block STRIPPED_LOG;
//        private Block STRIPPED_WOOD;
//        private Block PLANKS;
//        private Block STAIRS;
//        private Block SLAB;
//        private Block FENCE;
//        private Block FENCE_GATE;
//        private Block DOOR;
//        private Block TRAPDOOR;
//        private Block PRESSURE_PLATE;
//        private Block BUTTON;
//
//        public WoodSetBuilder() { }
//
//        public static WoodSetBuilder create() { return new WoodSetBuilder(); }
//        public static WoodSet build() {
//            return new WoodSet(this);
//        }
//        public static WoodSetBuilder setLog(Block log) { this.LOG = log; return this; }
//        public static WoodSetBuilder setWood(Block wood) { this.WOOD = wood; return this; }
//        public static WoodSetBuilder setStrippedLog(Block stripped_log) { this.STRIPPED_LOG = stripped_log; return this; }
//        public static WoodSetBuilder setStrippedWood(Block stripped_wood) { this.STRIPPED_WOOD = stripped_wood; return this; }
//        public static WoodSetBuilder setPlanks(Block planks) { this.PLANKS = planks; return this; }
//        public static WoodSetBuilder setStairs(Block stairs) { this.STAIRS = stairs; return this; }
//        public static WoodSetBuilder setSlab(Block slab) { this.SLAB = slab; return this; }
//        public static WoodSetBuilder setFence(Block fence) { this.FENCE = fence; return this; }
//        public static WoodSetBuilder setFenceGate(Block fence_gate) { this.FENCE_GATE = fence_gate; return this; }
//        public static WoodSetBuilder setDoor(Block door) { this.DOOR = door; return this; }
//        public static WoodSetBuilder setTrapdoor(Block trapdoor) { this.TRAPDOOR = trapdoor; return this; }
//        public static WoodSetBuilder setPressurePlate(Block pressure_plate) { this.PRESSURE_PLATE = pressure_plate; return this; }
//        public static WoodSetBuilder setButton(Block button) { this.BUTTON = button; return this; }
//    }
//
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        //if(block.getDefaultState().isOpaque()) { ModRenderLayers.registerCutout(block);  }
        return Registry.register(Registries.BLOCK, new Identifier(Super.MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block, ItemGroup group) {
        return registerBlock(name, block);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static ToIntFunction<BlockState> createLightLevelFromProperty(int litLevel, BooleanProperty property) {
        return state -> state.get(property) != false ? litLevel : 0;
    }

    private static Item registerBlockItem(String name, Block block) {
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem));
        return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), blockItem);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem));
        return registerBlockItem(name, block);
    }

    public static void registerModBlocks() {
        ModInit.LOGGER.debug("Registering mod blocks for " + Super.MOD_ID);
    }
}
