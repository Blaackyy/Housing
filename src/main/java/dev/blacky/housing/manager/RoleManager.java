package dev.blacky.housing.manager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.blacky.housing.Housing;
import dev.blacky.housing.model.HouseRole;

public final class RoleManager {
    private final Housing plugin;
    private final Multimap<HouseRole, String> roleCapabilities;

    public RoleManager(Housing plugin) {
        this.plugin = plugin;
        this.roleCapabilities = ArrayListMultimap.create();

        this.init();
    }

    private void init() {
        this.addRoleCapability(HouseRole.BOSS, "member.delete");
        this.addRoleCapability(HouseRole.BOSS, "member.add");
        this.addRoleCapability(HouseRole.BOSS, "member.promote");
        this.addRoleCapability(HouseRole.BOSS, "member.demote");

        this.addRoleCapability(HouseRole.SUB_BOSS, "member.delete");
        this.addRoleCapability(HouseRole.SUB_BOSS, "member.promote");
        this.addRoleCapability(HouseRole.SUB_BOSS, "member.demote");

        this.addRoleCapability(HouseRole.MEMBER, "member.invite");
    }

    public void addRoleCapability(HouseRole role, String capability) {
        this.roleCapabilities.put(role, capability);
    }

    public void removeRoleCapability(HouseRole role, String capability) {
        this.roleCapabilities.remove(role, capability);
    }

    public boolean hasRoleCapability(HouseRole role, String capability) {
        return this.roleCapabilities.containsEntry(role, capability);
    }
}
