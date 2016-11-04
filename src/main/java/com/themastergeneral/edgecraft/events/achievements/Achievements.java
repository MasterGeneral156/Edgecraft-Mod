package com.themastergeneral.edgecraft.events.achievements;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.themastergeneral.edgecraft.items.ModItems;

public class Achievements 
{
	public static Achievement ej;
	
	public static AchievementPage ECPage;
	
	public static final void init() 
    {
		ej = new Achievement("achievement.getBanana", "getBanana", 0, 0, ModItems.banana, null);
		
		
		ej.registerStat();
    }
	public static final void secondinit()
	{
		ECPage = new AchievementPage("Edgecraft Mod", ej);
		AchievementPage.registerAchievementPage(ECPage);
	}
}
