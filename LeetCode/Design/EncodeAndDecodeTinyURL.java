// https://leetcode.com/problems/encode-and-decode-tinyurl/description/

public class Codec {

    private Map<Integer, String> map = new HashMap<>();
    private int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(id, longUrl);
        return "http://Any.com/" + (id++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = Integer.parseInt(shortUrl.replace("http://Any.com/", ""));
        return map.get(key);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));