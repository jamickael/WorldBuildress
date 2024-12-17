package com.worldbuildress.conlang.Data;

import com.worldbuildress.conlang.models.Profile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProfileData {

    public static final Map<Integer, Profile> profiles = new HashMap<>();

    public static void add(Profile profile) {
        profiles.put(profile.getId(), profile);
    }

    public static Profile getById(Integer id) {
        return profiles.get(id);
    }

    public static Collection<Profile> getAll() {
        return profiles.values();
    }
}
