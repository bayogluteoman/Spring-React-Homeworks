package Managers;

import Entities.Campaign;
import Entities.Game;

public class CampaignManagers implements ICampaignService {

    @Override
    public void add(Campaign campaign) {
        System.out.println("***********************************************************");
        System.out.println("New "+campaign.getName()+" company added for "
                +campaign.getInfo()+" game. It has %"+
                campaign.getDiscount_amount()+" discount.");

    }

    @Override
    public void delete(Campaign campaign) {
        System.out.println("***********************************************************");
        System.out.println(campaign.getInfo()+" has been deleted");
    }

    @Override
    public void update(Campaign campaign, int newDiscountAmount) {
        campaign.setDiscount_amount(newDiscountAmount);
        System.out.println("The "+ campaign.getInfo()+" game has been updated."+
                "New discount amount is %"+campaign.getDiscount_amount());
    }
}
