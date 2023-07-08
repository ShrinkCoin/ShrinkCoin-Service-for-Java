# ShrinkCoinService

The `ShrinkCoinService` class provides a convenient way to interact with the ShrinkCoin API to perform various operations related to URL shrinking and tracking.

## Constructor

### `ShrinkCoinService(String apiKey)`

- `apiKey` (String): The API key associated with your ShrinkCoin account.

Creates a new instance of the `ShrinkCoinService` class with the specified API key.

## Methods

### `Map<String, Object> shrinkURL(String url, boolean isInstant) throws IOException`

- `url` (String): The URL to be shortened.
- `isInstant` (boolean): Specifies whether the URL should be instantly available or not.

This method sends a request to the ShrinkCoin API to shrink the given URL. It returns the response from the API as a map.

### `Map<String, Object> deleteURL(String id) throws IOException`

- `id` (String): The ID of the shortened URL to be deleted.

This method sends a request to the ShrinkCoin API to delete the specified shortened URL. It returns the response from the API as a map.

### `Map<String, Object> checkURLClicks(String id) throws IOException`

- `id` (String): The ID of the shortened URL for which to retrieve click information.

This method sends a request to the ShrinkCoin API to get the click information for the specified shortened URL. It returns the response from the API as a map.

### `Map<String, Object> checkURLCampaignClicks(String id, String campaign) throws IOException`

- `id` (String): The ID of the shortened URL for which to retrieve click information.
- `campaign` (String): The name of the campaign to filter the click information.

This method sends a request to the ShrinkCoin API to get the click information forthe specified shortened URL, filtered by the specified campaign. It returns the response from the API as a map.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY";
        ShrinkCoinService shrinkCoinService = new ShrinkCoinService(apiKey);

        // Shrink a URL
        String url = "https://example.com";
        try {
            Map<String, Object> result = shrinkCoinService.shrinkURL(url, true);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete a shrunk URL
        String id = "YOUR_URL_ID";
        try {
            Map<String, Object> result = shrinkCoinService.deleteURL(id);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check clicks for a URL
        id = "YOUR_URL_ID";
        try {
            Map<String, Object> result = shrinkCoinService.checkURLClicks(id);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check clicks for a URL campaign
        id = "YOUR_URL_ID";
        String campaign = "YOUR_CAMPAIGN";
        try {
            Map<String, Object> result = shrinkCoinService.checkURLCampaignClicks(id, campaign);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
Note: Replace "YOUR_API_KEY", "YOUR_URL_ID", and "YOUR_CAMPAIGN" with your actual API key, URL ID, and campaign name respectively.

That's it! You can use the ShrinkCoinService class in your Java code to integrate the ShrinkCoin API functionalities into your application.
