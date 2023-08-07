/**
 * 535. TinyURL 的加密与解密
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 * <p>
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 * <p>
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= url.length <= 104
 * 题目数据保证 url 是一个有效的 URL
 */

public class Question535_EncodeAndDecodeTinyURL {
	public static void main(String[] args) {

	}

	public class Codec {
		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			return longUrl;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			return shortUrl;
		}
	}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}

