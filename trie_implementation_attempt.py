trie_implementation = """
class TrieNode:
    def __init__(self):
        self.children = {}  # Map from character to TrieNode
        self.endOfWord = False  # True if node represents the end of the word

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        current = self.root
        for char in word:
            if char not in current.children:
                current.children[char] = TrieNode()
            current = current.children[char]
        current.endOfWord = True  # Mark the end of a word

    def search(self, word):
        current = self.root
        for char in word:
            if char not in current.children:
                return False
            current = current.children[char]
        return current.endOfWord  # Return True if we're at a word's end

    def startsWith(self, prefix):
        current = self.root
        for char in prefix:
            if char not in current.children:
                return False
            current = current.children[char]
        return True  # If we can traverse the trie up to the end of the prefix, it exists
"""

with open('trie_example.py', 'w') as file:
    file.write(trie_implementation)

print("Trie implementation has been saved to 'trie_example.py'.")