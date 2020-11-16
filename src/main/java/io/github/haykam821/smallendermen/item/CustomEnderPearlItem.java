package io.github.haykam821.smallendermen.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomEnderPearlItem extends EnderPearlItem {
	private final int cooldownDuration;
	private final float pitchIncrease;
	private final float throwSpeed;

	public CustomEnderPearlItem(int cooldownDuration, float pitchIncrease, float throwSpeed, Item.Settings settings) {
		super(settings);
		this.cooldownDuration = cooldownDuration;
		this.pitchIncrease = pitchIncrease;
		this.throwSpeed = throwSpeed;
	}

	/**
	 * Constructs a {@link CustomEnderPearlItem} with the same settings as vanilla ender pearls.
	 */
	public CustomEnderPearlItem(Item.Settings settings) {
		this(20, 0, 1.5f, settings);
	}

	private void spawnEntity(World world, PlayerEntity user, ItemStack stack) {
		EnderPearlEntity entity = new EnderPearlEntity(world, user);
		entity.setItem(stack);
		entity.setProperties(user, user.pitch, user.yaw, 0, this.throwSpeed, 1);
		world.spawnEntity(entity);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);

		float pitch = 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5f, pitch + this.pitchIncrease);

		user.getItemCooldownManager().set(this, this.cooldownDuration);
		user.incrementStat(Stats.USED.getOrCreateStat(this));

		// Spawn entity
		if (!world.isClient) {
			this.spawnEntity(world, user, stack);
		}

		if (!user.abilities.creativeMode) {
			stack.decrement(1);
		}
		return TypedActionResult.success(stack, world.isClient());
	}
}
