package samrg472.ref.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import samrg472.ref.References;

import java.util.Random;

public class EnergyBlockT2 extends BaseEnergyBlock {

    public EnergyBlockT2() {
        super(Tier.TWO);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        manipulateField(world, References.getRange(), References.invisibleEnergyBlock, x, y, z, isReceivingPower(world, x, y, z));
        notifyArea(world, this, x, y, z);
    }

}
