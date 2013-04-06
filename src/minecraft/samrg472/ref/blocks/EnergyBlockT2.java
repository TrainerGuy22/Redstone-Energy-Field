package samrg472.ref.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import samrg472.ref.RedstoneEnergyField;

import java.util.Random;

public class EnergyBlockT2 extends BaseEnergyBlock {
    
    public EnergyBlockT2(int id, Material material) {
        super(id, material, Tier.TWO);
        setUnlocalizedName("rsEnergyBlockT2");
    }
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        manipulateField(world, RedstoneEnergyField.range, RedstoneEnergyField.invisibleEnergyBlock.blockID, x, y, z, isProvidingPower(world, x, y, z));
        notifyArea(world, 1, this.blockID, x, y, z);
    }
    
}
