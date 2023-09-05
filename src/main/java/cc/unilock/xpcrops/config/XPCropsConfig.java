package cc.unilock.xpcrops.config;

import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.api.annotations.Comment;
import org.quiltmc.config.api.values.TrackedValue;

public class XPCropsConfig extends ReflectiveConfig {
	@Comment("Minimum XP to drop")
	public final TrackedValue<Integer> min_xp = this.value(3);

	@Comment("Maximum XP to drop")
	public final TrackedValue<Integer> max_xp = this.value(5);

	@Comment("Chance for XP to drop (1 in X)")
	public final TrackedValue<Integer> chance = this.value(5);
}
