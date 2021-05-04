package Managers;

import Entities.Campaign;

public interface ICampaignService {
    void add(Campaign campaign);
    void delete(Campaign campaign);
    void update(Campaign campaign, int newDiscountAmount);
}
