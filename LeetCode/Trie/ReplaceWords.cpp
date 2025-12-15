/// https://leetcode.com/problems/replace-words/description/?envType=problem-list-v2&envId=trie

class Solution {
private:
    struct Node {
        unordered_map<char, Node*> children;
        bool isEnd;

        Node(){
            isEnd = false; 
            this->children = unordered_map<char, Node*>();
        }
    };
    Node *root = new Node();
    void insert(string word){
        Node* curr = root; 

        for(char ch : word){
            auto it = curr->children.find(ch);
            if(it == curr->children.end()) 
                curr->children[ch] = new Node();
            
            curr = curr->children[ch];
        }
        curr->isEnd = true;
    }

    string findRoot(string& word) {
        Node* curr = root;
        string prefix;

        for (char ch : word) {
            if (!curr->children.count(ch))
                return word; 

            curr = curr->children[ch];
            prefix.push_back(ch);

            if (curr->isEnd)
                return prefix;
        }
        return word;
    }


public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        for (string& str : dictionary)
            insert(str);

        string result, word;
        sentence.push_back(' ');

        for (char c : sentence) {
            if (c == ' ') {
                result += findRoot(word);
                result.push_back(' ');
                word.clear();
            } else {
                word.push_back(c);
            }
        }

        result.pop_back();
        return result;
    }
};    