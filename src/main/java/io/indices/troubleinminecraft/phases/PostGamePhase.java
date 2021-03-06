package io.indices.troubleinminecraft.phases;

import io.indices.troubleinminecraft.features.PostGameFeature;
import me.minidigger.voxelgameslib.GameConstants;
import me.minidigger.voxelgameslib.feature.features.*;
import me.minidigger.voxelgameslib.phase.TimedPhase;
import org.bukkit.GameMode;

public class PostGamePhase extends TimedPhase {

    @Override
    public void init() {
        setName("PostGamePhase");
        super.init();
        setAllowJoin(false);
        setAllowSpectate(true);
        setTicks(20 * GameConstants.TPS); // 20 seconds

        MapFeature mapFeature = getGame().createFeature(MapFeature.class, this);
        mapFeature.setShouldUnload(false);
        addFeature(mapFeature);

        SpawnFeature spawnFeature = getGame().createFeature(SpawnFeature.class, this);
        spawnFeature.setInitialSpawn(false);
        addFeature(spawnFeature);

        ScoreboardFeature scoreboardFeature = getGame().createFeature(ScoreboardFeature.class, this);
        addFeature(scoreboardFeature);

        NoBlockBreakFeature noBlockBreakFeature = getGame()
                .createFeature(NoBlockBreakFeature.class, this);
        addFeature(noBlockBreakFeature);

        NoBlockPlaceFeature noBlockPlaceFeature = getGame()
                .createFeature(NoBlockPlaceFeature.class, this);
        addFeature(noBlockPlaceFeature);

        NoDamageFeature noDamageFeature = getGame().createFeature(NoDamageFeature.class, this);
        addFeature(noDamageFeature);

        GameModeFeature gameModeFeature = getGame().createFeature(GameModeFeature.class, this);
        gameModeFeature.setGameMode(GameMode.ADVENTURE);
        addFeature(gameModeFeature);

        PostGameFeature postGameFeature = getGame().createFeature(PostGameFeature.class, this);
        postGameFeature.setScoreboard(scoreboardFeature.getScoreboard());
        addFeature(postGameFeature);
    }
}
