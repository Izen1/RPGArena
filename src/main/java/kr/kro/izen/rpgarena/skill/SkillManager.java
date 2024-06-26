package kr.kro.izen.rpgarena.skill;

public class SkillManager {

    private SwordSkill swordSkill = new SwordSkill();
    private AxeSkill axeSkill = new AxeSkill();
    private BowSkill bowSkill = new BowSkill();

    public SwordSkill getSwordSkill() {
        return swordSkill;
    }

    public AxeSkill getAxeSkill() {
        return axeSkill;
    }

    public BowSkill getBowSkill() {
        return bowSkill;
    }
}
