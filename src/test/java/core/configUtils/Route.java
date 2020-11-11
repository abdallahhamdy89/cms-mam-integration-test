package core.configUtils;

import com.plutotv.test.mam.lib.constants.ContentItemType;

import java.util.Optional;

public class Route {
    private static final String ENGINE = "/engine-rest";
    private static final String API = "/api";

    private static final PropertiesHolder PROPERTIES_HOLDER = PropertiesHolder.getInstance();

    public static String getOpenApiUrl() {
        return PROPERTIES_HOLDER.getClientUrl();
    }

    public static String getRestUrl() {
        return PROPERTIES_HOLDER.getRestUrl();
    }

    public static String getS3Url() {
        return PROPERTIES_HOLDER.getS3Url();
    }

    public static String getUrlContentItemValidationReport(int id) {
        return String.format("/content-items/%d/validation-reports/latest", id);
    }

    public static String getUrlFeeds() {
        return "/feeds";
    }

    public static String getUrlFeedsBluevo() {
        return "/feeds?provider=bluevo";
    }

    public static String getUrlFeedsMrss() {
        return "/feeds?provider=mrss";
    }

    public static String getUrlContentPartnerImport() {
        return "/content-partners/import";
    }

    public static String getMediaOrders() {
        return "/media-orders";
    }

    public static String getConfigIngestFeeds() {
        return "/ingest-configs";
    }

    public static String getCreateConfigIngestFeeds() {
        return "/new-ingest-feed";
    }


    public static String getConfigIngestFeed(int id) {
        return ("/ingest-configs/" + id);
    }

    public static String getMediaOrdersDetails() {
        return "/media-orders/MEDIA_ORDER_ID/media-order-items";
    }

    public static String getCamundaInstanceVars(String instanceId) {
        return String.format(ENGINE + "/process-instance/%s/variables", instanceId);
    }

    public static String getCamundaInstanceTaskCount(String instanceId) {
        return ENGINE + "/external-task/count?processInstanceId=" + instanceId;
    }

    public static String getUrlIngestValidation(int feedId) {
        return "/ingest-validation/" + feedId + "/";
    }

    public static String getUrlIngest() {
        return "/ingest-list";
    }

    public static String getUrlIngestSession( int offset, int limit) {
        return String.format("/ingest-sessions?offset=%s&limit=%s", offset, limit);
    }

    public static String getUrlContentItemsSearch(int limit, int offset, ContentItemType contentItemType, Optional<String> title, Optional<String> rating) {
        String url = String.format("/content-items/search?limit=%s&offset=%s", limit, offset);
        if (title.isPresent()) {
            url += "&title=" + title.get();
        }
        if (rating.isPresent()) {
            url += "&rating=" + rating.get();
        }
        return url + "&contentItemType=" + contentItemType.getName();
    }

    public static String getUrlContentItemsSearch() {
        return "/content-items/search";
    }

    public static String getUrlContentItems() {
        return "/content-items";
    }

    public static String getContentTypesUrl() {
        return "/ingest-sessions/types";
    }

    public static String getIngestStatusesUrl() {
        return "/ingest-sessions/statuses";
    }

    public static String getContentPartnersUrl() {
        return "/content-partners";
    }

    public static String getMrssDefaults() {
        return "/ingest-configs/mrss-defaults";
    }

    public static String getImportMediaOrders() {
        return "/media-orders/import";
    }

    public static String getValidationReport(int feedId) {
        return String.format("/content-items/%s/validation-reports/latest", feedId);
    }

    public static String getQCManager() {
        return "/qc-manager";
    }

    public static String getPutNewRoleUrl(String userId) {
        return String.format("/users/%s", userId);
    }

    public static String getSearchRoleUrl(String userName) {
        return String.format("/users?name=%s", userName);
    }

    public static String getQcWorkQueueUrl() {
        return "/qc-work-queue";
    }

    public static String getQcJobsUrl() {
        return "/qc-jobs?limit=999";
    }

    public static String getQcJobAssigneeUrl() {
        return "/qc-jobs/assign";
    }

    public static String getQcJobSearchUrl(String searchValue) {
        return String.format("/qc-jobs?title=%s", searchValue);
    }

    public static String getManageIngestUrl() {
        return "/ingest-list";
    }

    public static String getAdminUsersUrl() {
        return "/users";
    }

    public static String getAddUserUrl(){
        return getAdminUsersUrl() + "/add";
    }

    public static String getLimit(String limit){
        return String.format("?limit=%s", limit);
    }

    public static String getMockServerUrl() {
        return PROPERTIES_HOLDER.getMockServerUrl();
    }
    public static String getMockServerExpectationUrl() {
        return "/mockserver/expectation";
    }

    public static String getMockServerExpectationUrlData() {
        return "/mockserver/expectation";
    }
}
