package samrg472.ref.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import samrg472.ref.References;

import java.util.Random;

public class InvisibleBlock extends BaseEnergyBlock {

    public static final String unlocalizedName = "invisiblePoweredBlock";

    public InvisibleBlock(Material material) {
        super(material, unlocalizedName);
        setCreativeTab(null);
        disableStats();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canProvidePower() {
        return References.canConnectEverything();
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        notifyArea(world, this, x, y, z);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        notifyArea(world, this, x, y, z);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int par6) {
        notifyArea(world, this, x, y, z);
    }

    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int metadata, EntityPlayer player) {
        world.setBlock(x, y, z, Blocks.air, 0, 0x02);
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 0;
    }

    @Override
    public boolean isAir(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
        return false;
    }

    @Override
    public boolean isBlockSolid(IBlockAccess world, int x, int y, int z, int side) {
        return side == ForgeDirection.DOWN.ordinal();
    }

}
