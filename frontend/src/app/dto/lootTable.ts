import { LootItem } from "./lootItem";

export interface LootTable {
    data: LootItem[],
    total: number;
  }