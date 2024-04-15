export interface Loot {
  name: string;
  itemEffect: string;
  itemSource: string;
  itemLocation: string;
  type: string;
  subtype: string;
  price: number;
}

export interface LootTable {
  data: Loot[],
  // page: number;
//  pageSize: number;
  total: number;
//  total_pages: number;
}