/*
Author: Bruno Luca
Date: 28/01/2020
Ex: create a c program that create a 
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

//define tree structure
struct tree_node{
    struct tree_node *left;
    struct tree_node *right;
    int key;
    int val;
};

//define a function that insert a element in a tree
void insert(struct tree_node ** tree, struct tree_node* new){
    if(*tree == NULL){
        printf("Primo inserimento\n");
        *tree = new;
        (*tree)->left = NULL;
        (*tree)->right = NULL;
    }else{
        printf(" inserimento\n");
        if(new->key < (*tree)->key) insert(&(*tree)->left, new);
        else if(new->key > (*tree)->key) insert(&(*tree)->right, new);
        else printf("\n|CHIAVE DUPLICATA|\n");
    }
}

//define a function that search a element by key
struct tree_node * find_by_key(struct tree_node *tree, int key){
    if(tree == NULL) return NULL;
    else{
        if(key < tree->key) find_by_key(tree->left, key);
        else if (key > tree->key) find_by_key(tree->right, key);
        else return tree;
    }
}

//
void in_order_view(struct tree_node * tree){
    if(tree != NULL){
        in_order_view(tree->left);
        printf("Key %d, value %d" , tree->key, tree->val);
        in_order_view(tree->right);
    }

}

int main(){
    struct tree_node * albero = (struct tree_node*) malloc(sizeof(struct tree_node));
    struct tree_node *cipresso = (struct tree_node*) malloc(sizeof(struct tree_node));
    struct tree_node * pino = (struct tree_node*) malloc(sizeof(struct tree_node));

    albero->val = 10;
    albero->key = 5;
    albero->right = NULL;
    albero->left = NULL;

    cipresso->val = 9;
    cipresso->key = 4;

    pino->val = 11;
    pino->key = 6;

    insert(&albero,pino);
    insert(&albero, cipresso);

    in_order_view(albero);
}


