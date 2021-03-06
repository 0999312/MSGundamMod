package com.spaceboyross.gundam.ms.gundams;

import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;
import com.spaceboyross.gundam.ms.armaments.BeamSaberMSArmament;
import com.spaceboyross.gundam.ms.armaments.VulcanGunMSArmament;
import com.spaceboyross.gundam.ms.gundams.RX782GundamMobileSuit.MSMob;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MSZ006ZetaGundamMobileSuit extends MobileSuit {
	
	public MSZ006ZetaGundamMobileSuit() {
		this.setHeight(65.125f);
		this.setModel("MSZ-006");
		this.setName("Zeta Gundam");
		
		this.addArmament(new VulcanGunMSArmament(2,60));
		this.addArmament(new BeamSaberMSArmament(2));
		
		this.addRecipeItem("gundam:gundarium_gamma_ingot",20);
	}
	
	@Override
	public MSMob createEntity(World worldIn,Vec3d pos) {
		MSMob mob = new MSZ006ZetaGundamMobileSuit.MSMob(worldIn);
		mob.setPosition(pos.x,pos.y,pos.z);
		return mob;
	}
	
	public static class MSMob extends MobileSuit.MSMob {
		public MSMob(World worldIn) {
			super(worldIn);
			this.scale = 6.8f;
			this.setSize(1.0f*this.scale,2.0f*this.scale);
		}
		
		@Override
		public MobileSuit getMSRegistryEntry() {
			return MSRegistry.getMobileSuit("MSZ-006 Zeta Gundam");
		}
	}

}
