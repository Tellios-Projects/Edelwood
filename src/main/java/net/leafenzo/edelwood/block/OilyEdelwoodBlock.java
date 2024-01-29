package net.leafenzo.edelwood.block;

import net.leafenzo.edelwood.sound.ModSoundEvents;
import net.leafenzo.edelwood.state.ModProperties;
import net.leafenzo.edelwood.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class OilyEdelwoodBlock extends Block {
    public static final BooleanProperty SILENT = ModProperties.SILENT;

    public OilyEdelwoodBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(SILENT, true));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.get(SILENT)) {
            world.playSound(null, pos, ModSoundEvents.BLOCK_EDELWOOD_COUGH, SoundCategory.AMBIENT, 1.0f, 1.0f);
//            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS); // just triggers the getStateForNeighborUpdate
        }
    }

//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
//        if(neighborState.isOf(this)) {
//            if(!neighborState.get(SILENT)) {
//
//                world.scheduleBlockTick(pos, this, 5);  // pos.offset(direction) might also be necessary for cellular automata behavior, I don't remember quite right though
//            }
//        }
//        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
//    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(SILENT, true);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(SILENT);
    }
}
